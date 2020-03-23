package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> q1 = new ArrayBlockingQueue<>(100);
        BlockingQueue<String> q2 = new LinkedBlockingQueue<>();
        BlockingQueue<String> q3 = new PriorityBlockingQueue<>();
    }
}
