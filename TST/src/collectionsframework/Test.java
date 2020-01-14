package collectionsframework;

public class Test {
    public static void main(String[] args) {
        MyStack<Integer> myStack1 = new MyStack<>();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(30);
        myStack1.push(40);
        myStack1.push(50);
        myStack1.push(60);
        myStack1.push(70);
        myStack1.push(80);
        myStack1.push(90);
        myStack1.push(100);
        myStack1.push(110);
        System.out.println(myStack1.pop());//40
        System.out.println(myStack1.peek());//30
        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("hello");
        myStack2.push("world");
        myStack2.push("!!!");
        System.out.println(myStack2.pop());//!!!
        System.out.println(myStack2.peek());//world
        /*MyArrayList<String> myArrayList1 = new MyArrayList<>();
        myArrayList1.add("hello");
        myArrayList1.add("world");
        myArrayList1.add("!!!");
        System.out.println(myArrayList1.get());
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        myArrayList2.add(1);
        myArrayList2.add(2);
        myArrayList2.add(3);
        System.out.println(myArrayList2.get());
        //MyArrayList<int> myArrayList3 = new MyArrayList<>();  错误的*/
    }
}
