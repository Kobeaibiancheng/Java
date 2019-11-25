public class Person {
    //成员属性
    private String name;
    private int age;
    private String sex;
    {
        this.name = "小明";
        this.age = 19;
        this.sex = "man";
        System.out.println("hi");
    }
    //成员方法
    public void show(){
        System.out.println("name: " + name + " age: " + age + " sex: " + sex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

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
/*    public void eat() {
        System.out.println("吃饭");
    }
    public void study() {
        System.out.println("学习");
    }
    //构造方法
    public Person() {
        System.out.println("hello");
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
    public Person(String name,int age,String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        System.out.println("姓名:" + this.name);
        System.out.println("age:" + this.age);
        System.out.println("sez:" + this.sex);
    }*/


}
