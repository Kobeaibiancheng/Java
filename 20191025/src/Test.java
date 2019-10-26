import java.util.Scanner;

     //类名
class Person {
/*    类体：
         属性（）
         行为（方法）*/

    //实例成员数据
    String name1 = "yuxiang";
    int age1 = 19;

    //静态成员数据
    static String name2 = "xiangxiang";
    static int age2 = 19;

    //实例成员方法
    public void study() {
        System.out.println("study");
    }
    public void play() {
        System.out.println("play");
    }

    //静态成员方法
    public static void sleep() {
        System.out.println("sleep");
    }
    public static void exam() {
        System.out.println("exam");
    }



}
public class Test {
    public static void main(String[] args) {
        Person per = new Person();
        System.out.println(per.age1);
        System.out.println(per.name1);
        per.play();
        per.study();
        
    }
}
