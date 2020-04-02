package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SomeSimpleThreadPool {
    public static void main(String[] args) {
        //线程池
        ExecutorService p1 = Executors.newFixedThreadPool(10);
        //线程池
        ExecutorService p2 = Executors.newCachedThreadPool();
    }
}