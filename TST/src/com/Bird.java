package com;

public class Bird extends Animal{
    public String name;

    public Bird(String name) {
        super(name);
        this.name = name;
    }
    public void eat() {
        System.out.println(this.name + "eat");
    }
}
