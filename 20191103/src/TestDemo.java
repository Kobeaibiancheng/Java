class Number {
    public int num;
    public Number(int num) {
        this.num = num;
    }
}
public class TestDemo {
    public static void swap(Number num1,Number num2) {
        int tmp = num1.num;
        num1.num = num2.num;
        num2.num = tmp;
    }
    public static void main(String[] args) {
        Number num1 = new Number(10);
        Number num2 = new Number(20);
        System.out.println(num1.num + " "+ num2.num);
        swap(num1,num2);
        System.out.println(num1.num + " "+ num2.num);
    }
}
