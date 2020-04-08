package IO;

import java.io.*;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("用于读的文件.txt");
        //is.read(); // 一次只读一个字节  返回值  实际读到的数据
        // 什么时候就知道把所有的内容都读完了呢？
        // End Of Stream: EOS

        byte[] buf = new byte[2];//返回读到的长度
        int len;
        while ((len = inputStream.read(buf)) != -1) {
            System.out.println("读一次");
            for (int i = 0; i < len; i++) {
                System.out.println(buf[i]);
            }
        }
        inputStream.close();


        /*byte[] buff = new byte[1024];
        while((len=inputStream.read(buff))!=-1) {
            outputStream.write(buff, 0, len);
        }*/

        /**
         *  中文输入
         */
        try (InputStream is = new FileInputStream("中文输入utf8.txt")) {
            readContent(is, "UTF-8");
        }

        System.out.println("=========================");

        try (InputStream is = new FileInputStream("中文输入gb18030.txt")) {
            readContent(is, "GB18030");
        }

    }

    private static void readContent(InputStream is, String charset) throws IOException {
        byte[] buf = new byte[8192];
        int len;

        // 这里利用了一个特性，buf 可以一次性的把所有数据都都进来
        while ((len = is.read(buf)) != -1) {
            for (int i = 0; i < len; i++) {
                System.out.println(buf[i]);
            }

            String s = new String(buf, 0, len, charset);
            System.out.println(s);
        }
    }
}
