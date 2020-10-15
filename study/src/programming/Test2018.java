package programming;

import java.util.Arrays;
import java.util.Scanner;

public class Test2018 {

    /**
     * 输入字符串，以 "*#*"作为结束标志，判断每个字符串中0-9数字各有多少
     * @param str
     * @return
     */
    static int howManyNumber(String str) {
        //int i = 0;
        char[] arr = str.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9'){
                count++;
            }
        }
        return count;
    }

    /**
     *输入n个学生得姓名和成绩，按成绩排序后输出，输入包括m组数据
     */
    static void studentNameAndScore() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            Student[] students = new Student[n];
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                String[] strings = str.split(" ");
                students[i] = new Student(strings[0],Double.parseDouble(strings[1]));
            }
            Arrays.sort(students);
            System.out.println(Arrays.toString(students));
        }
    }
    public static void main(String[] args) {
        studentNameAndScore();
        /*Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //System.out.println(howManyNumber(sc.nextLine()));

        }*/
    }
}
