package com.study.Test;

public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
    public void eat() {
        System.out.println("Animal" + "eat()");
    }
}
