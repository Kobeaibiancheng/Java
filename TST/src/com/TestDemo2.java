package com;

import javafx.scene.paint.CycleMethod;

class TestDemo2 {
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();

        Shape shape = new Rect();
        Shape shape2 = new Cycle();
        Shape shape3 = new Flower();
        drawMap(shape);
        drawMap(shape2);
        drawMap(shape3);
    }

}
