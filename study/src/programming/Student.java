package programming;

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
}
