package com;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HttpServletResponse {

    private static final Map<Integer,String> reasonMap = new HashMap<>();
    static {
        reasonMap.put(200,"OK");
        reasonMap.put(400,"Bad Request");
        reasonMap.put(404,"Not Found");
        reasonMap.put(500,"Internal Server Error");

    }

    private int status = 200;
    private Map<String,String> headerMap = new HashMap<>();
    private OutputStream outputStream;
    private ByteArrayOutputStream bodyOutputStream = new ByteArrayOutputStream(8192);
    private PrintWriter bodyPrintWriter;


    public HttpServletResponse() throws UnsupportedEncodingException {
        bodyPrintWriter = new PrintWriter(new OutputStreamWriter(bodyOutputStream,"UTF-8"));
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setHeader(String name,String value) {
        headerMap.put(name,value);
    }

    public void setContentType(String contentType) {
        setHeader("Content-Type",contentType);
    }

    public PrintWriter getWriter() throws UnsupportedEncodingException {
        return bodyPrintWriter;
    }

    public static HttpServletResponse build(OutputStream outputStream) throws UnsupportedEncodingException {
        HttpServletResponse response = new HttpServletResponse();

        //基本的初始化功能
        response.outputStream = outputStream;

        return response;
    }

    public void send() throws IOException {
        bodyPrintWriter.flush();

        int contentLength = bodyOutputStream.size();

        setHeader("Content-Length",String.valueOf(contentLength));
        PrintWriter printWriter = new PrintWriter(
                new OutputStreamWriter(outputStream,"utf-8")
        );

        //1.先写响应行
        sendResponseLine(printWriter);
        sendResponseHeaders(printWriter);
        printWriter.flush();
        sendResponseBody(outputStream);
        outputStream.flush();
    }

    private void sendResponseBody(OutputStream outputStream) throws IOException {
        outputStream.write(bodyOutputStream.toByteArray());
    }

    private void sendResponseHeaders(PrintWriter printWriter) {
        for (Map.Entry<String,String> entry : headerMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            printWriter.print(key);
            printWriter.print(": ");
            printWriter.print(value);
            printWriter.print("\r\n");
        }
        printWriter.print("\r\n");
    }

    private void sendResponseLine(PrintWriter printWriter) {
        //<HTTP/1.0> 空格 <状态> 空格 <状态描述> CRLF

        printWriter.print("HTTP/1.0");
        printWriter.print(status);
        printWriter.print(reasonMap.get(status));
        printWriter.print("\r\n");
    }

    @Override
    public String toString() {
        return "HttpServletResponse{" +
                "status=" + status +
                ", headerMap=" + headerMap +
                ", outputStream=" + outputStream +
                ", bodyOutputStream=" + bodyOutputStream +
                ", bodyPrintWriter=" + bodyPrintWriter +
                '}';
    }
}
