package collectionsframework;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList1 = new MyArrayList<>();
        myArrayList1.add("hello");
        myArrayList1.add("world");
        myArrayList1.add("!!!");
        System.out.println(myArrayList1.get());
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        myArrayList2.add(1);
        myArrayList2.add(2);
        myArrayList2.add(3);
        System.out.println(myArrayList2.get());
        //MyArrayList<int> myArrayList3 = new MyArrayList<>();  错误的
    }
}
