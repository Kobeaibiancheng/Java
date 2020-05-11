package com;

import java.io.UnsupportedEncodingException;

public interface MyServlet {
    void init();

    void service(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException;

    void destroy();
}
