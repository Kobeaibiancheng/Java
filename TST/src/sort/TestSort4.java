package sort;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student>{
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
    public int compareTo(Student o) {

        return this.age - o.age;
        //年龄按从小到大
        /*
        Student student = (Student)o;
        if (this.age > student.age) {
            return 1;
        }else if (this.age < student.age) {
            return -1;
        }else {
            return 0;
        }*/
    }
}
class ComparatorByName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null){
            return 1;
        }
        return o1.name.compareTo(o2.name);
    }
}
class ComparatorByAge implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
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
        ComparatorByAge comparatorByAge = new ComparatorByAge();
        ComparatorByName comparatorByName = new ComparatorByName();

        Arrays.sort(students,comparatorByName);
        //Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
