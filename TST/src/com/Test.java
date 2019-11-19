package com;

public class Test {
    public ListNode mergeTwoLists(ListNode headA,ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(headA != null && headB != null) {
            if(headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }
            else{
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA == null) {
            tmp.next = headB;
        }
        else {
            tmp.next = headA;
        }
        return newHead.next;

    }
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addLast(1);
        singleList.addLast(2);
        singleList.addLast(3);
        singleList.addLast(4);
        singleList.addLast(5);
        System.out.println(singleList.addIndex(3,6));

        singleList.display();

    }
}
