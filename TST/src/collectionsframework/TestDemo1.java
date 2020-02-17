package collectionsframework;

import java.util.*;

public class TestDemo1 {
    public static void main(String[] args) {
        //Collection接口
        /*Collection<String> collection = new ArrayList<>();
        collection.add("java");
        collection.add("hello");
        System.out.println(collection.isEmpty());
        collection.remove("java");
        collection.add("2020");
        collection.add("2019");
        System.out.println(collection);
        Object[] strings = collection.toArray();
        System.out.println(Arrays.toString(strings));*/

        Collection<String> list = new ArrayList<>();
        list.add("I");
        list.add(" miss");
        list.add(" you");
        list.add(" kobe");
        list.add(" !");
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.remove(" !"));
        for (String s : list) {
            System.out.print(s);
        }
        System.out.println();
        Object[] myWords = list.toArray();
        System.out.println(Arrays.toString(myWords));
        System.out.println(list);
        list.clear();
        System.out.println(list);
        /*false
        5
        true
        I miss you kobe
        [I,  miss,  you,  kobe]*/

        /*for (String s : collection) {
            System.out.println(s);
        }*/

        Map<String,String> map = new HashMap<>();
        map.put("Kobe","basketball");
        map.put("Gigi","daught");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("Kobe"));
        map.getOrDefault("霍华德","扣篮");
        System.out.println(map.containsKey("Kobe"));
        System.out.println(map.containsValue("basketball"));
        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        /**
         * map接口
         * <>指定数据类型是什么
         */
        /*Map<String,String> map = new HashMap<>();

        map.put("国民女神","高圆圆");
        map.put("国民老公","王思聪");
        map.put("黑旋风","李逵");
        map.put("及时雨","宋江");
        System.out.println(map);
        //String str = map.get("及时雨");
        String str = map.getOrDefault("及时雨2","小明");
        System.out.println(str);
        System.out.println(map.containsKey("国民老公"));
        System.out.println(map.containsValue("李逵"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());*/

    }
}
