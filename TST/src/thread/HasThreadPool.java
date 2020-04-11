package thread;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HasThreadPool {

    static class Factory extends Thread{
        String courier;
        public Factory(String courier) {
            this.courier = courier;
        }

        @Override
        public void run() {
            System.out.println("开始送courier：" + courier);
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("courier送完了：" + courier);
        }
    }


    public static void main(String[] args) {
        //一个线程池    大小为10
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String courier = sc.nextLine();
            Factory task = new Factory(courier);
            executorService.execute(task);
        }
    }
}
