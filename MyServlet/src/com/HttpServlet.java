package com;

import java.io.UnsupportedEncodingException;

public abstract class HttpServlet implements MyServlet{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        switch(req.getMethod()) {
            case "GET":
                doGet(req,resp);
                break;
            case "POST":
                doPost(req,resp);
                break;
            default:
                resp.setStatus(400);
        }
    }

    public void doGet(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
        // Method Not Allow
        resp.setStatus(405);
    }

    public void doPost(HttpServletRequest req,HttpServletResponse resp) {
        // Method Not Allow
        resp.setStatus(405);
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }
}
