

public class Test {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addLast(1);
        singleList.addLast(2);
        singleList.addLast(3);
        singleList.addLast(2);
        singleList.addLast(1);
        //singleList.display();
        //singleList.addFirst(15);
        //singleList.addIndex(0,1);
        //System.out.println(singleList.contains(60));
/*      singleList.remove(20);
        singleList.remove(10);
        singleList.remove(5);
        singleList.remove(0);
        //singleList.removeAllKey(2);
        System.out.println(singleList.size());*/
        singleList.display();
        //singleList.displayRev(singleList.reverseList());
        //System.out.println(singleList.middleNode2().data);
        //System.out.println(singleList.findKthToTail(3).data);
        //ListNode cur = singleList.partition(4);
        //System.out.println(singleList.chkPalindrome());
        singleList.createLoop();
        System.out.println(singleList.hasCycle());
        System.out.println(singleList.detectCycle().data);
        //singleList.displayRev(singleList.deleteDuplication());
    }
}
