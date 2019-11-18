package com.study.Test;

public class Animal {
    protected String name;

    static {
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类实例代码块");
    }
    public Animal(String name) {
        this.name = name;
        System.out.println("父类构造方法");
    }
    public void eat() {
        System.out.println("Animal" + "eat()");
    }
}
