package thread;

class A extends Thread{
    @Override
    public void run() {
        System.out.println("我是A");
    }
}
class B extends Thread{
    @Override
    public void run() {
        System.out.println("我是B");
    }
}





public class TestDemo2 {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 100; i < 110; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }




    //匿名内部类创建线程对象
    public static void noNameThread() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                //这里指定线程要执行的代码
            }
        };

        //lamda表达式
        Thread c = new Thread(() ->{

        });
    }
    public static void main(String[] args) throws InterruptedException {
        Thread A = new MyThread();
        A.start();
        A.join();
        System.out.println("a结束了");

        Thread B = new Thread(new MyRunnable());
        B.start();
        B.join();
        System.out.println("b结束了");

        Thread c = new Thread(new MyThread());
        c.start();
        c.join();
        System.out.println("c 一定结束了");


        /*
        A a = new A();
        B b = new B();


        //把a,b放到就绪队列中
        a.start();
        b.start();
        *//**
         * main 线程被切换下来
         * CPU 从就绪队列中选 A,B,main
         *
         *//*
        System.out.println("我是main");*/
    }
}
