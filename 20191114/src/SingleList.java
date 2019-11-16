class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
class SingleList {
    public ListNode head;
    public SingleList() {
        this.head = null;
    }


    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head == null) {
            this.head = node;
            return;
        }
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public void display() {
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public void display2(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public ListNode middleNode() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList() {
        ListNode prev = null;
        ListNode newHead = null;
        ListNode cur = this.head;
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

    //获得单链表的长度
    public int getLength() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode removeElements(int key) {
        ListNode prev = this.head;
        ListNode cur = prev.next;
        while(cur != null) {
            if(prev.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        if(this.head.data == key) {
            return this.head.next;
        }
        return head;
    }


    //求单链表的倒数第k个节点
    public ListNode findKthToTail(int k) {
        ListNode fast = this.head;
        ListNode slow = this.head;
        for (int i = 0; i < k-1; i++) {
            if(fast.next != null){
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

    //判断是否是回文结构
    public boolean chkPalindrome() {
        if(this.head == null) {
            return false;
        }
        if(this.head.next == null) {
            return true;
        }
        //找到中间节点
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转后半部分的节点
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //slow 往前走  head 往后走
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

    //制造一个有环的单链表
    public void createLoop() {
        this.head.next.next = this.head.next;
    }

    //判断链表是否有环
    public boolean hasCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
    //找到单链表环的入口，返回该节点
    public ListNode detectCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        slow = this.head;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //以x为基准分割单链表
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
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs == null) {
            return as;
        }
        be.next = as;
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针

}

