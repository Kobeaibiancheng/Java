package thread;

import java.util.Scanner;

/*
单生产者-单消费者情况

1. 是不是线程安全的？   是否有共享，是否有修改?
2. 怎么修改成线程安全的版本？ 通过加锁解决
                              volatile 不可以解决问题
3. 生产者在队列满时等待-消费者在队列空时等待
4. 生产者需要唤醒可能在等消费者；消费者需要唤醒可能在等的生产者
*/
public class MyBlockingQueue {
    int[] array = new int[10];
    int front = 0;
    int rear = 0;
    int size = 0;


    //入队

    /*
    synchronized  锁的是 this 所指向的对象
     */
    synchronized public void offer(int value) throws InterruptedException {

        while (this.size == array.length) {
            //throw new RuntimeException("队列已满");
            this.wait();//所以锁this指向的对象
        }
        //走到这里   this.size 肯定不等于 array.length
        this.array[this.rear] = value;
        this.rear = (this.rear+1)%this.array.length;
        this.size++;//我们需要保障的是 size++ 的原子性，所以 volatile 无法解决
        System.out.println(size); // 1 - 10
        this.notifyAll();// 我们以为我们唤醒的是消费者线程，但实际可能唤醒了生产者线程
    }

    //出队
    synchronized public int pop() throws InterruptedException {
        if (size == 0) {
            // 空的
            //throw new RuntimeException("队列已空");
            this.wait();
        }

        int value = array[this.front];
        this.front++;
        this.front = (this.front + 1) % this.array.length;
        this.size--;
        System.out.println(size); // 1 - 10
        this.notifyAll();

        return value;
    }

    static MyBlockingQueue queue = new MyBlockingQueue();


    static class Producer extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println("准备放入 " + i);
                    queue.offer(i);
                    System.out.println("放入成功");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        producer.start();

        Thread.sleep(2 * 1000);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            scanner.nextLine();
            System.out.println(queue.pop());
        }
    }
}
