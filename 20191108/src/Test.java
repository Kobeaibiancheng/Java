public class Test {
    public static void main(String[] args) {
        SingleList single = new SingleList();
/*      single.addFirst(10);
        single.addFirst(20);
        single.addFirst(30);
        single.addFirst(40);
        single.addFirst(50);
        single.addFirst(60);
*/
        single.addLast(10);
        single.addLast(20);
        single.addLast(30);
        single.addLast(40);
        single.addLast(50);

        System.out.println(single.middleNode().data);
        single.display();
    }
}
