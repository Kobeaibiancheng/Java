public class Test {
    public static void main(String[] args) {
        SingleList single = new SingleList();
        single.addLast(1);
        single.addLast(2);
        single.addLast(3);
        single.addLast(2);
        single.addLast(1);
        System.out.println(single.chkPalindrome());
        /*single.makeCycle();
        System.out.println(single.isCycle());
        System.out.println(single.detectCycle().data);
      single.addFirst(10);
        single.addFirst(20);
        single.addFirst(30);
        single.addFirst(40);
        single.addFirst(50);
        single.addFirst(60);
        System.out.println(single.findKthToTail(0).data);
        System.out.println(single.middleNode().data);
        single.display2(single.partition(4));*/
    }
}
