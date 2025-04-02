package thread;


/**
 * 创建线程方法二：实现Runnable接口，复写run()方法
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("线程的代码在这里执行");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
