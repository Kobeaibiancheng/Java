package com.study.Test;

public class Cat extends Animal{
    protected String name;
    protected String color;

    public Cat(String name,String color) {
        super(name);
        this.name = name;
        this.color = color;
    }
    public void eat() {
        System.out.println("Cat" + " eat()");
    }

    public void sleep(){
        System.out.println("Cat" + " sleep()");
    }
}
