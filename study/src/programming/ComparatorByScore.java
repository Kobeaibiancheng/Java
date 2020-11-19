package programming;

import java.util.Comparator;
//根据成绩排序
class ComparatorByScore implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int)(o1.score-o2.score);
    }
}
