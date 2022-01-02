package mysql;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
      //无参的构造方法：代码执行到这里，当前的时间
      java.util.Date date1 = new java.util.Date();

      //传入long类型的数据，表示从1970年开始，经过1000毫秒后，到达的时间
      java.util.Date date2 = new java.util.Date(1000);
      java.sql.Date date3 = new java.sql.Date(1000);




    }
}
