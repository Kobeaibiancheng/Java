class Sta {
    public static int a = 0;
    public int count = 0;
    static {
        a = 10;
        System.out.println("a = " + a);
    }
    public static void hello() {
        System.out.println("hello");
    }
}
public class Test {
    public static void main(String[] args) {

/*        Sta sta1 = new Sta();
        Sta sta2 = new Sta();*/

/*      Calculator cal1 = new Calculator();
        Person per1 = new Person();
        Person per2 = new Person("zhangsan");
        Person per3 = new Person("lisi",18);
        per1.study(5);
        System.out.println(cal1.add(2,3));
        System.out.println(cal1.div(2,3));
        System.out.println(cal1.mul(2,3));
        System.out.println(cal1.sub(2,3));*/
        Person person = new Person();
        person.setName("李四");
        person.setSex("man");
        person.setAge(19);
        System.out.println(person.getAge());
        System.out.println(person.getName());
        System.out.println(person.getSex());

    }
}
