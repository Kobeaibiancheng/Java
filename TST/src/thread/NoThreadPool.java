package thread;

import java.util.Scanner;

public class NoThreadPool {
    static class Deliver implements Runnable{
        String courier;
        public Deliver(String courier) {
            this.courier = courier;
        }

        @Override
        public void run() {
            System.out.println("开始送courier:" + courier);
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("courier送完了:" + courier);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String courier = sc.nextLine();
            Runnable worker = new Deliver(courier);
            worker.run();
        }
    }
}
