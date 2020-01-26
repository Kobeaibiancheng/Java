package sort;

import java.util.Arrays;

class Student implements Comparable{
    protected String name;
    protected int score;
    protected int age;

    public Student(String name,int score,int age) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student)o;
        //年龄按从小到大
        if (this.age > student.age) {
            return 1;
        }else if (this.age < student.age) {
            return -1;
        }else {
            return 0;
        }
    }
}
public class TestSort4 {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("张三",80,20),
                new Student("李四",70,18),
                new Student("王五",90,30),
        };
        /*Student student1 = new Student("张三",80,20);
        Student student2 = new Student("李四",70,18);
        Student student3 = new Student("王五",90,30);
        Student[] students = {student1,student2,student3};*/
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
