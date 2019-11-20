package com;

public class Cat extends Animal {
    public int age;
    public Cat(String name,int age){
        super(name);
        this.name = name;
        this.age = age;
    }
    @Override
    public void eat() {
        System.out.println(this.name + "eat");
    }
}
