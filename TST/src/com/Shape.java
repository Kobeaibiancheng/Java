package com;

class Shape {
    public void draw() {

    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个⚪");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个♦");
    }
}

class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个❀");
    }
}