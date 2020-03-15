package thread;

import java.util.Scanner;

public class UsageOfWait {
    static Object o = new Object();
    static class Print extends Thread{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 50; i++) {
                    System.out.println(i);

                    if (i == 30) {
                        // 我等在 o 上
                        synchronized (o) {
                            o.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Print print = new Print();
        print.start();
        Thread.sleep(2 * 1000);
        System.out.println("输入任意字符，以唤醒 Print 线程");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        synchronized (o) {
            o.notify();
        }
    }
}
