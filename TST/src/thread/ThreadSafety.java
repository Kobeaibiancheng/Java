package thread;

public class ThreadSafety {
    synchronized void mothed(){
        //同步方法
        /**
         * 争夺的是 this 指向的对象的锁
         */
    }
    synchronized void statMothed(){
        //同步静态方法
        /**
         * 争夺的是 类名.class 指向的对象的锁
         * 可通过类名.class 找到对象
         */
    }

    void otherMethod(){
        Object o = new Object();
        synchronized (o) {
            //同步代码块
            /**
             * synchronized 代码块中，争夺的是引用指向的对象的锁
             */
        }
    }
}
