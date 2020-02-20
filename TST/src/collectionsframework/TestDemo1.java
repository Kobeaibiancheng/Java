package collectionsframework;

import java.util.*;

public class TestDemo1 {

    //宝石和石头
    public static int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < J.length();i++) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for(int i = 0;i < S.length();i++) {
            if(set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }



    //复制带随机指针的链表
    public static Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            Node node = new Node(cur.data);
            map.put(cur,node);
            cur = cur.next;
        }

        cur = head;

        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }


    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("I");
        set.add("miss");
        set.add("you");
        set.add("kobe");
        System.out.println(set);

        //迭代器->只要实现了iterable接口
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }


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

        /*Collection<String> list = new ArrayList<>();
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
        System.out.println(list);*/
        /*false
        5
        true
        I miss you kobe
        [I,  miss,  you,  kobe]*/

        /*for (String s : collection) {
            System.out.println(s);
        }*/

        /*Map<String,String> map = new HashMap<>();
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
        }*/

        /**
         * Map:底层是一个哈希表
         * <key,v>  key 不能相同  ，v 可以相同
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
