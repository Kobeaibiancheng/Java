public class Calculator {
    //成员属性
    private int num1;
    private int num2;
    //构造方法
    public Calculator() {
        System.out.println("加减乘除");
    }
    //成员方法
    public int add(int num1,int num2) {
        return num1+num2;
    }
    public int mul(int num1,int num2) {
        return num1*num2;
    }
    public int sub(int num1,int num2) {
        return num1-num2;
    }
    public int div(int num1,int num2) {
        return num1/num2;
    }
}