package com;

import java.util.Arrays;

/**
 * 1.自定义类型实现Comparable接口
 * 2.重写compareTo方法
 * 3.Arrays.sort()排序
 */
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public double score;

    public Student(String name,int age,double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

}
class TextDome5 {
    public static void main(String[] args) {

        Student[] students = new Student[3];
        students[0] = new Student("zhangsan",18,78.6);
        students[1] = new Student("lisi",17,68.6);
        students[2] = new Student("wangwu",16,58.6);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
