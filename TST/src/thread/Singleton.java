package thread;

/**
 * 单例模式
 * 懒汉（延迟加载）
 * 正确
 * 效率还比较高
 * 通过：1.volatile 的引入，目的解决了 instance = new ...();重排序问题
 *       2.synchronized 的引入，目的是解决 原子性问题
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {}

    // 1. 为什么要把加锁的过程放到 ins == null 里头 —— 提升效率
    // 2. 为什么需要进行二次判断 —— 抢锁成功之后，条件可能发生了变化
    public synchronized static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();// 这个代码是有重排序问题的
                    //可能导致 instance 不为 null 时，但 instance 指向的对象
                    //没有被完全初始化好
                }
            }
        }
        return instance;
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            Singleton ins1 = Singleton.getInstance();
            System.out.println(ins1);
        }
    }

    public static void main(String[] args) {
        MyThread[] threads = new MyThread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new MyThread();
        }
        for (int i = 0; i < 20; i++) {
            threads[i].start();
        }
        Singleton ins1 = Singleton.getInstance();
        Singleton ins2 = Singleton.getInstance();
        Singleton ins3 = Singleton.getInstance();

        System.out.println(ins1 == ins2);
        System.out.println(ins2 == ins3);
    }
}