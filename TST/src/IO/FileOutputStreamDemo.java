package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException{
        try(OutputStream os = new FileOutputStream("用于输出.txt")){
            byte[] buf = new byte[1024];


            /*buf[0] = (byte)'l';
            buf[1] = (byte)'m';
            buf[2] = (byte)'i';
            buf[3] = (byte)'s';
            buf[4] = (byte)'s';
            buf[5] = (byte)'y';
            buf[6] = (byte)'o';
            buf[7] = (byte)'u';
            buf[8] = (byte)'k';
            buf[9] = (byte)'o';
            buf[10] = (byte)'b';
            buf[11] = (byte)'e';*/

            String s = "l miss you kobe!";
            byte[] bytes = s.getBytes();
            os.write(bytes);


            // 输出流为了减少 IO 的次数，有可能进行了数据缓冲（不是马上写入硬盘，而是写在内存中）
            os.flush(); // 保证把所有缓冲的数据全部写入硬盘中
            // 调用 os.close() 一般都会在其内部调用 os.flush();
        }
    }
}
