package thread;


/**
 * 创建线程第一种办法：继承Threads类，复写父类 的run()方法。
 */
public class MyThread extends Thread{


    @Override
    public void run() {
        System.out.println("线程的代码在这里执行");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }

}
