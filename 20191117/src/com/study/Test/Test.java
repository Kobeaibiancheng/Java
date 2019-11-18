package com.study.Test;

public class Test {
    public static void main(String[] args) {
        //System.out.println("will work at alibaba!");
        Cat cat = new Cat("小花","白色");
        System.out.println(cat.name + cat.color);
        cat.eat();
        cat.sleep();
    }
}
