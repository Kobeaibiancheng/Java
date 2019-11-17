public class Test {
    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        //遍历两个单链表
        while (headA != null && headB != null) {
            if(headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }
            else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA == null) {
            tmp.next = headB;
        }
        if(headB == null) {
            tmp.next = headA;
        }
        return newHead.next;
    }
    public static void main(String[] args) {
/*        SingleList single1 = new SingleList();
        single1.addLast(1);
        single1.addLast(2);
        single1.addLast(4);
        single1.addLast(6);
        SingleList single2 = new SingleList();
        single2.addLast(0);
        single2.addLast(3);
        single2.addLast(5);
        single2.addLast(7);
        single1.display2(mergeTwoLists(single1.head,single2.head));*/
        DoubleList doubleList = new DoubleList();
        doubleList.addFirst(1);
        doubleList.addFirst(2);
        doubleList.addFirst(3);
        doubleList.addFirst(4);
        doubleList.addFirst(99);
        doubleList.addIndex(0,99);
        doubleList.addIndex(1,99);
        doubleList.addFirst(5);
        doubleList.display();
        System.out.println();
        doubleList.remove(99);
        doubleList.display();
        System.out.println();
        doubleList.removeAllKey(99);
        doubleList.display();
    }
}
