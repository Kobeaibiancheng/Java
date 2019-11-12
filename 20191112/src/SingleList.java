class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

}
class SingleList {
    ListNode head;
    public SingleList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        //判断是否是第一次插入
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        //判断是否是第一次插入
        if(this.head == null) {
            this.head = node;
            return;
        }
        ListNode cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //打印单链表
    public void display() {
        ListNode cur = this.head;
        if(this.head == null) {
            return;
        }
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
    //打印单链表
    public void display2(ListNode newHead) {
        if(newHead == null) {
            return;
        }
        ListNode cur = newHead;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
    //反转单链表
    public ListNode reverseList1() {
        //prev表示将要反转的节点的前驱
        ListNode prev = null;
        //cur表示将要反转的节点
        ListNode cur = this.head;
        //newHead反转后单链表新的头
        ListNode newHead = null;
        while(cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public ListNode reverseList2() {
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while(cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    //求单链表的中间节点
    public ListNode middleNode() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //求单链表倒数第k个节点
    public ListNode findKthToTail(int k) {
        ListNode fast = this.head;
        ListNode slow = this.head;
        //快慢引用：fast先走k-1步，然后fast和slow同时走，当fast.next == null即走到链表左后一个节点时
        //          slow的位置就是倒数第k个节点
        for (int i = 0; i < k-1; i++) {
            //如果只有一个节点
            if(fast.next != null) {
                fast = fast.next;
            }
            else {
                System.out.println("没有该节点");
                return null;
            }
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //以x为基准分割链表
    public ListNode partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.data < x) {
                if(bs == null) {
                    bs = cur;
                    be = cur;
                }
                else {
                    be.next = cur;
                    be = be.next;
                }
            }
            else {
                if(as == null) {
                    as = cur;
                    ae = cur;
                }
                else {
                    ae.next = cur;
                    ae = cur;
                }
            }
            cur = cur.next;
        }
        //小于x的区间没有数据
        if(bs == null){
            return as;
        }
        be.next = as;
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }

    //删除有序链表中重复的节点，前提是有序
    public ListNode deleteDuplication() {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.next != null && cur.data == cur.next.data) {
                while(cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            }
            else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }

    //
    public void createCut(ListNode headA,ListNode headB) {
        headA.next = headB.next.next;
    }

    //判断单链表是否为回文结构
    public boolean chkPalindrome() {
        //1.找到中间节点
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.反转中间节点后半部分
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3.slow/fast     head同时走
        while(slow != this.head) {
            if(slow.data == this.head.data) {
                slow = slow.next;
                this.head = this.head.next;
            }
            else {
                return false;
            }
            if(this.head.next == slow) {
                return true;
            }
        }
        return true;
    }

    //



}
