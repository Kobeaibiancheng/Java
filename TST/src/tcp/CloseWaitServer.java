package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class CloseWaitServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8099);
        while (true) {
            Socket socket = serverSocket.accept();

            // 没有关闭 socket，就直接循环下一次了
            //socket.close();
        }
    }
}
