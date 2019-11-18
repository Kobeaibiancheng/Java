package com.study.Test;

public class Cat extends Animal{
    protected String color;

    static {
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类实例代码块");
    }
    public Cat(String name,String color) {
        super(name);
        this.name = name;
        this.color = color;
        System.out.println("子类构造方法");
    }
/*    public void eat() {
        System.out.println("Cat" + " eat()");
    }*/

    public void sleep(){
        System.out.println("Cat" + " sleep()");
    }
}
