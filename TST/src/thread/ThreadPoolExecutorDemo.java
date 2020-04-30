package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    //线程池
    public static void main(String[] args) {
        // 创建了一个
        ExecutorService executorService = new ThreadPoolExecutor(
                10,// 最多有 10 个正式员工
                20,// 最多有 20 个员工包括正式和临时
                60,// 临时工空闲时间最多有 60 SECONDS
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(30) // 传递任务的队列是一个 ArrayBlockingQueue（容量是 30）
                // 执行默认的拒绝策略：处理不过来之后抛出异常
        );
        // ExecutorService 引用可以指向一个线程池对象


        executorService.execute(new Runnable() {
            @Override
            public void run() {
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
            }
        });
        // 怎么关闭线程池
        executorService.shutdown();  // 推荐使用上面的
        executorService.shutdownNow();
    }
}
