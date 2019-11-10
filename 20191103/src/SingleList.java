class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
class SingleList {
    public ListNode head;//标志头

    public SingleList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
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
        if(head == null) {
            this.head = node;
            return;
        }
        //找尾巴
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //打印单链表数据
    public void display() {
        if(this.head  == null) {
            return;
        }
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }



    /**
     * 找到index-1的位置，返回当前位置的引用
     * @param index
     * @return
     */
    private ListNode searchIndex(int index) {
        //prev-->index-1;
        ListNode prev = this.head;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }
        return prev;
    }
    //插入到index位置
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        //下标不合法
        if(index < 0 || index > getLength()) {
            return false;
        }
        //头插法
        if(index == 0) {
            addFirst(data);
            return true;
        }
        ListNode prev = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        return false;
    }
    //
    public int getLength() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }



    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    //找到要删除节点的前驱
    private ListNode search(int key) {
        ListNode prev = head;
        while(prev.next != null) {
            if(prev.next.data == key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        //1.删除的节点是头节点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //2.找到删除的节点的前驱  如果找不到  返回null
        ListNode prev = search(key);
        if(prev == null) {
            System.out.println("没有该节点");
            return;
        }
        ListNode del = prev.next;
        //3.进行删除
        prev.next = del.next;
    }


    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur != null){
            if(prev.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        //删除头节点
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }

    public void clear() {
        //this.head = null;
        while(this.head.next != null) {
            ListNode cur = this.head.next;
            this.head.next = cur.next;
        }
    }





    //打印反转单链表
    public void displayRev(ListNode newHead) {
        ListNode prev = newHead;

        while(prev != null) {
            System.out.print(prev.data + " ");
            prev = prev.next;
        }
    }
    //反转单链表
    public ListNode reverseList1() {
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while(cur != null) {
            ListNode curNext = cur.next;
            if(curNext == null) {
                newHead =cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    /**
     * 头插法反转单链表
     */
 /*   public ListNode reverseList2() {
        ListNode prev = this.head;
        ListNode cur = this.head.next;

        
    }*/
    //压栈




    //求单链表中间节点
    public ListNode middleNode1() {
        ListNode cur = this.head;
        for (int i = 0; i < getLength()/2; i++) {
            cur = cur.next;
        }
        return cur;
    }
    //求单链表中间节点       优化写法
    public ListNode middleNode2() {
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

        if(k < 0 || this.head == null) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        for (int i = 0; i < k-1; i++) {
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
                //判断是不是第一次尾插法
                if(bs == null) {
                    bs = cur;
                    be = cur;
                }
                else {
                    be.next = cur;
                    be = cur;
                }
            }
            else {
                //判断是不是第一次尾插法
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
        if(bs == null) {
            return as;
        }
        //将尾节点next置为null
        if(ae != null) {
            ae.next = null;
        }
        be.next = as;
        return bs;
    }

    //删除有序链表中重复的节点，前提是有序
    public ListNode deleteDuplication() {
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(cur != null) {
            //重复的节点
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
        //最后一个节点如果也是重复的，需要将tmp.next = null
        tmp.next = null;
        return newHead.next;
    }


    //判断单链表是否为回文结构
    public boolean chkPalindrome() {
        if(this.head == null) {
            return false;
        }
        if(this.head.next == null) {
            return true;
        }
        //1.找到中间节点
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.反转中间节点的后半部分
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3.fast/slow 往前走， head 往后走
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


    //制造一个带环的单链表
    public void createLoop() {
        ListNode cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }
    /**
     * fast走两步，slow走一步
     * 一个走一步，一个走三步耗费的时间会长，甚至有可能不能够相遇
     * 判断链表是否有环，并且找到环的入口，写博客总结
     */
    //判断单链表是否有环
    public boolean hasCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    //找到单链表环的入口
    public ListNode detectCycle() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
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
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
