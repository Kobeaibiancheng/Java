package com;

import com.HttpServletRequest;
import com.webapps.ROOT.WebXML;

import java.net.Socket;
import java.util.Map;

public class TransactionTask implements Runnable {
    private final Socket socket;


    public TransactionTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // HTTP 1.0 协议 一条TCP 连接中只处理一组 HTTP 请求——响应


        try {
            //1.读取 TCP 连接中的输入
            //2.遵照 HTTP 请求的格式，解析输入
            //3.解析过程中可能读到错误格式的请求（直接不处理）
            //4.解析成功，封装成HttpServletRequest对象
            HttpServletRequest request = HttpServletRequest.readAndParse(socket.getInputStream());
            // 为了观察中间步骤——DEBUG
            System.out.println(request);
            //5.构建一个空得 HttpServletResponse 对象（进行基本的初始化）
            HttpServletResponse response = HttpServletResponse.build(socket.getOutputStream());

            //6.区分是静态资源还是动态资源

            //7.先只考虑动态资源 - 如何根据 URL 找到对应的 Servlet 类
            MyServlet servlet = WebXML.map(request.getPath());
            if (servlet == null) {
                //404
            }else {
                System.out.println(servlet.getClass().getCanonicalName());
                servlet.service(request,response);
                //response 就被应用正确填充了
                System.out.println(response);
                //8.按照 response 中得内容，组装成 HTTP 响应格式
                response.send();
                System.out.println(response);
            }

            socket.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
