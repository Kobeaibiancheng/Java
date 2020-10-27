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

    /**
     * 输入年月日，问这是今年第几天
     * @param str
     * @return
     */
    static int howManyDays(String str) {
        String[] strings = str.split(" ");
        int count = 0;
        if (isLeapYear(Integer.valueOf(strings[0]))) {
            for (int i = 1; i <
                    Integer.valueOf(strings[1]); i++) {
                switch(i){
                    case 1:
                        count += 31;
                        break;
                    case 2:
                        count += 29;
                        break;
                    case 3:
                        count += 31;
                        break;
                    case 4:
                        count += 30;
                        break;
                    case 5:
                        count += 31;
                        break;
                    case 6:
                        count += 30;
                        break;
                    case 7:
                        count += 31;
                        break;
                    case 8:
                        count += 31;
                        break;
                    case 9:
                        count += 30;
                        break;
                    case 10:
                        count += 31;
                        break;
                    case 11:
                        count += 30;
                        break;
                    case 12:
                        count += 31;
                        break;
                }
            }
            count += Integer.valueOf(strings[2]);
            return count;
        }else {
            for (int i = 1; i < Integer.valueOf(strings[1]); i++) {
                switch(i){
                    case 1:
                        count += 31;
                        break;
                    case 2:
                        count += 28;
                        break;
                    case 3:
                        count += 31;
                        break;
                    case 4:
                        count += 30;
                        break;
                    case 5:
                        count += 31;
                        break;
                    case 6:
                        count += 30;
                        break;
                    case 7:
                        count += 31;
                        break;
                    case 8:
                        count += 31;
                        break;
                    case 9:
                        count += 30;
                        break;
                    case 10:
                        count += 31;
                        break;
                    case 11:
                        count += 30;
                        break;
                    case 12:
                        count += 31;
                        break;
                }
            }
            count += Integer.valueOf(strings[2]);
            return count;
        }
    }

    private static boolean isLeapYear(Integer integer) {
        if (integer % 400 == 0 || (integer % 4 == 0 && integer % 100 != 0)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);
        /*System.out.println(howManyDays("2000 2 15"));
        studentNameAndScore();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //System.out.println(howManyNumber(sc.nextLine()));

        }*/
    }
}
