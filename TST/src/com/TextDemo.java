package com;



public class TextDemo {
    public static void main(String[] args) {
        //向上转型
        Animal animal = new Cat("小白", 2);
/*        System.out.println(((Cat) animal).age);
        System.out.println(animal.name);
        animal.eat();*/

        //向下转型
        Animal animal2 = new Bird("小鸟");
        animal2.eat();
        Bird bird = (Bird) animal2;

        Animal animal3 = new Cat("小明", 3);
        if (animal3 instanceof Bird) {
            Bird bird2 = (Bird) animal3;
        }
    }
}