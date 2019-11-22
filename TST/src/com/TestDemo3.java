package com;


class Cycle2 implements IShape {
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}
class Flower2 implements IShape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
class Triangle2 implements IShape {
    @Override
    public void draw() {
        System.out.println("🔺");
    }
}
class TestDemo3 {
    public static void drawMap(IShape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        IShape shape = new Cycle2();
        Cycle2 cycle = new Cycle2();
        drawMap(shape);
        drawMap(cycle);
    }
}
