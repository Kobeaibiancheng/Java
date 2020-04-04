package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CustomThreadPool {


    static class Worker extends Thread{
        private BlockingQueue<Runnable> workQueue;

        Worker(BlockingQueue<Runnable> workQueue) {
            this.workQueue = workQueue;
        }
        @Override
        public void run() {
            //不停的从队列中取任务并且完成任务
            while (!Thread.interrupted()) {
                Runnable task = null;
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    break;//退出
                }
                //完成任务
                task.run();
            }
        }
    }
    //1.传递任务用的阻塞队列
    BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
    //2.基础所有线程的对象
    List<Worker> workerList = new ArrayList<>();

    CustomThreadPool(int nThreads) {

        //2.创建所有的工作线程
        for (int i = 0; i < nThreads; i++) {
            Worker worker = new Worker(workQueue);
            worker.start();
            workerList.add(worker);
        }
    }

    void execute(Runnable task) throws InterruptedException {
        workQueue.put(task);
    }
    void shutDown() {
        // 让所有的线程都停止工作
        // 可以使用 interrupt 建议一个线程停下来
        // 实际上 Worker 什么时候停，你处理不了
        for (Worker worker : workerList) {
            worker.interrupt();
        }
    }
}
