package com.webapps.ROOT;

import com.MyServlet;

import java.util.HashMap;
import java.util.Map;


public class WebXML {
    static Map<String,String> servletMapping = new HashMap<>();
    //key: servlet-name
    //value: servlet-class ,简单是实现成 Servlet 对象
    static Map<String, MyServlet> servlet = new HashMap<>();

    static {
        servlet.put("Hello",new HelloServlet());
        servlet.put("Login",new LoginServlet());

        servletMapping.put("/login","Login");
        servletMapping.put("/hello","Hello");
    }

    public static MyServlet map(String path) {
        String servletName = servletMapping.get(path);
        if (servletName == null) {
            return null;
        }

        return servlet.get(servletName);
    }
}
