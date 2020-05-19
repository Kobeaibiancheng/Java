package com.webapps.ROOT;

import com.HttpServlet;
import com.HttpServletRequest;
import com.HttpServletResponse;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //TODO:验证用户名密码是否正确
        //TODO:设置 Session 信息

        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("登陆成功");
    }
}
