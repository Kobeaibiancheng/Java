public class Test {

    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(headA != null && headB != null) {
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
        else {
            tmp.next = headA;
        }
        return newHead.next;
    }

    //

    //输入两个链表，找出它们的第一个公共结点
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        //
        if(headA == null || headB ==null) {
            return null;
        }
        ListNode pL = headA;//pL指向长链表
        ListNode pS = headB;//pS指向短链表
        int lenA = 0;
        int lenB = 0;
        //求lenA
        while (pL != null) {
            lenA++;
            pL = pL.next;
        }
        //求lenB
        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;
        //差值
        int len = lenA - lenB;
        if (len < 0) {
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        //让pL 先走len步
        for (int i = 0; i < len; i++) {
            pL = pL.next;
        }
        //一起走
        while (pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
        return pL;
    }

    public static void main(String[] args) {

/*        singleList.addFirst(1);
        singleList.addFirst(2);
        singleList.addFirst(3);
        singleList.addFirst(4);
        singleList.addFirst(5);
        singleList.display2(singleList.reverseList());
        System.out.println(singleList.middleNode().data);
        System.out.println(singleList.findKthToTail(1).data);
        singleList.display2(singleList.partition(3));
        System.out.println(singleList.chkPalindrome());
        singleList.display2(mergeTwoLists(singleList.head,singleList1.head));
        singleList.display2(singleList.deleteDuplication());*/
        SingleList singleList = new SingleList();
        singleList.addLast(1);
        singleList.addLast(2);
        singleList.addLast(3);
        singleList.addLast(5);
        singleList.addLast(6);
        singleList.addLast(8);

        SingleList singleList1 = new SingleList();
        singleList1.addLast(4);
        singleList1.addLast(5);
        singleList1.addLast(9);
        singleList1.addLast(10);
        singleList.createCut(singleList.head,singleList1.head);
        System.out.println(getIntersectionNode(singleList.head,singleList1.head).data
        );

    }
}
