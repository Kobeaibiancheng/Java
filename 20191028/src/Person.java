public class Person {
    //成员属性
    private String name;
    private int age;
    //成员方法
    public void study(int num) {
            switch(num) {
                case 1:
                    System.out.println("English");
                    break;
                case 2:
                    System.out.println("Chinese");
                    break;
                case 3:
                    System.out.println("math");
                    break;
                case 4:
                    System.out.println("Physics");
                    break;
                default:
                    System.out.println("Don't have this course");
                    break;
            }
    }

    //构造方法
    public Person() {
        System.out.println();
    }
    public Person(String name) {
        this.name = name;
        System.out.println("姓名:" + this.name);
    }
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("姓名:" + this.name);
        System.out.println("age:" + this.age);
    }

}
