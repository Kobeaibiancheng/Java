package collectionsframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
    public String name;
    public String clas;
    public double score;
    public Student(String name,String clas,double score) {
        this.name = name;
        this.clas = clas;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clas='" + clas + '\'' +
                ", score=" + score +
                '}';

    }
}
public class TestDemo3 {

    /**
     * 杨辉三角
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        //行数
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRows = new ArrayList<>();
            curRows.add(1);
            //上一行
            List<Integer> prevRow = triangle.get(i-1);
            //第i行的第j列
            for (int j = 1; j < i; j++) {
                int tmp  = prevRow.get(j-1) + prevRow.get(j);
                curRows.add(tmp);
            }
            curRows.add(1);
            triangle.add(curRows);
        }
        return triangle;
    }
    public static void main(String[] args) {
        List<List<Integer>> ret = generate(3);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }


    /**
     * "welcome to cvte"
     * "come"
     * =>"wl t vt"
     * @param str1
     * @param str2
     * @return
     */
    public static List<Character> func(String str1,String str2) {
        List<Character> ret = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!str2.contains(str1.charAt(i) + "")){
                ret.add(str1.charAt(i));
            }
        }
        return ret;
    }
    public static void main2(String[] args) {
        String str1 = "welcome to cvte";
        String str2 = "come";
        List<Character> ret = func(str1,str2);
        for (int i = 0; i < ret.size(); i++) {
            System.out.print(ret.get(i));
        }
        System.out.println();

        List<Student> list = new ArrayList<>();
        list.add(new Student("张三","三班",70));
        list.add(new Student("李四","三班",65));
        list.add(new Student("王五","三班",80));
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
        for (Student student : list) {
            System.out.println(student);
        }
    }
    public static void main1(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("java");
        list1.add("hello");
        System.out.println(list1);
        list1.add(1,"sun");
        System.out.println(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("world");

        //boolean addAll(Collection<? extends E> c)
        //传入的参数一定是实现了Collection接口的，?一定是E的子类或者E本身
        list1.addAll(list2);
        System.out.println(list1);
        String str = list1.remove(1);
        System.out.println(str);
        list1.remove("java");
        System.out.println(list1);
        //修改已有元素
        list1.set(1,"1");
        System.out.println(list1);
        System.out.println(list1.contains("java"));
        //返回第一个遇到的o下标
        System.out.println(list1.indexOf("2020"));
        //返回最后遇到的o的下标
        System.out.println(list1.lastIndexOf("1"));
        List<String> ret = list1.subList(0,2);
        System.out.println(ret);

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(8);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
