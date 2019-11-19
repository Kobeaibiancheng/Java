package com;

public class Cat extends Animal {
    public Cat(String name){
        super(name);
        this.name = name;
    }

    public void eat() {
        System.out.println(this.name + "eat");
    }
}
