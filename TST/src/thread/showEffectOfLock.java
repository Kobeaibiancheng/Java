package thread;

public class showEffectOfLock {
    static long n = 0;
    static long COUNT = 100_0000;
    static Object o = new Object();


    static class Adder extends Thread{
        @Override
        public void run() {
            for (long i = 0; i < COUNT; i++) {
                synchronized (o) {
                    n++;
                }
            }
        }
    }

    static class Subber extends Thread{
        @Override
        public void run() {
            for (long i = 0; i < COUNT; i++) {
                synchronized (o) {
                    n++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Adder adder = new Adder();
        Subber subber = new Subber();
        adder.start();
        subber.start();

        adder.join();
        subber.join();

        System.out.println(n);
    }
}
