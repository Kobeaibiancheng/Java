package com.webapps.ROOT;

import com.HttpServlet;
import com.HttpServletRequest;
import com.HttpServletResponse;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        String target = req.getParameter("target");
        if (target == null) {
            target = "世界";
        }

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE HTML>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset='utf-8'>");
        writer.println("<title>你好世界</title>");
        writer.println("<head>");
        writer.println("<body>");
        writer.println("<h1>你好" + target + "<h1>");
        writer.println("<body>");
        writer.println("<html>");
    }
}
