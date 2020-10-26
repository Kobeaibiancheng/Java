package programming;

import java.util.Arrays;
import java.util.Scanner;

public class Student implements Comparable<Student>{
    String name;
    double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return (int) this.score - (int) o.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            Student[] students = new Student[n];
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                String[] strings = str.split(" ");
                students[i] = new Student(strings[0],Double.parseDouble(strings[1]));
            }

            ComparatorByScore comparatorByScore = new ComparatorByScore();
            ComparatorByName comparatorByName = new ComparatorByName();

            Arrays.sort(students,comparatorByScore);
            //Arrays.sort(students);
            System.out.println(Arrays.toString(students));
        }
    }

}
