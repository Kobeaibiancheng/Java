package com;


/**
 * 内部类：
 * 1.实例内部类
 * 2.静态内部类
 * 3.匿名内部类
 */
class OutClass {
    public int data = 1;

    public static int size = 10;
    public OutClass() {
        System.out.println("OutClass()");
    }

    public void test() {
        System.out.println("OutClass test()");
    }

    /**
     * 实例内部类:
     * 1.如何获取实例内部类的对象？
     *      OutClass.InnerClass innerClass = outClass.new InnerClass();
     *      外部类  .  内部类  变量 =  外部类对象的引用 . new 内部类();
     * 2.在实例内部类当中，不能定义static的属性和方法
     *      如果要定义，那么这个属性一是要static final
     *      实例内部类里面的成员，一定是在编译期间就能确定的
     * 3.面试问题：
     *      实例内部类有没有额外的内存开销？
     *      有：因为实例内部类，包含外部类的this引用
     *      实例内部类至少有两个this
     */
    class InnerClass {
        public int value = 2;
        public int data = 19;
        public InnerClass() {
            System.out.println("InnerClass()");
        }

        public void test() {
            System.out.println("InnerClass.test()");
            System.out.println("data:" + data);//内部类的data = 19
            System.out.println("data:" + this.data);//内部类的data = 19
            System.out.println("Out data：" + OutClass.this.data);//外部类的data = 1
        }
    }
}



class  StaOutClass {
    public int data = 8;

    public StaOutClass() {
        System.out.println("StaOutClass");
    }
    /**
     * 静态内部类
     * 1.如何拿到静态内部类的对象？
     *      StaOutClass.StaInnerClass staInnerClass = new StaOutClass.StaInnerClass();
     *      外部类 .  内部类    变量名 = new 外部类.内部类()
     * 2.静态内部类当中不能够访问非静态数据成员
     *   如果说非要访问呢？
     *   传入外部类对象的引用
     * 3.静态内部类，不拥有外部类的this
     */
    static class StaInnerClass {
        public int value = 6;
        //public int data = 10;
        public static int size = 24;//可以定义静态属性

        StaOutClass staOutClass;

        public StaInnerClass() {
            System.out.println("static StaInnerClass");
        }
        public StaInnerClass(StaOutClass o) {
            this.staOutClass = o;
            System.out.println("static StaInnerClass");
        }
        public void test() {
            System.out.println("Out data:" + this.staOutClass.data);
        }
    }
}
public class TestDemo11 {
    public static void main(String[] args) {
        /**
         * 匿名内部类
         * 本质：其实就是一个子类
         */
        new OutClass(){
            @Override
            public void test() {
                System.out.println("test()");
            }
        }.test();





        /**
         * 静态内部类
         */
        /*StaOutClass outClass = new StaOutClass();
        StaOutClass.StaInnerClass staInnerClass = new StaOutClass.StaInnerClass(outClass);
        staInnerClass.test();*/



        /**
         * 实例内部类
         */
        /*OutClass outClass = new OutClass();
        System.out.println(outClass.data);
        //错误的，内部类的实例，依赖于外部类的对象
        //InnerClass innerClass = new InnerClass();
        OutClass.InnerClass innerClass = outClass.new InnerClass();

                                        //外部类对象的引用
        //OutClass.InnerClass innerClass = new OutClass().new InnerClass();
        innerClass.test();
        //System.out.println(innerClass.value);*/

    }
}
