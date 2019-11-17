class ListNode{
    public int data;
    public ListNode next;
    public ListNode prev;
    public ListNode(int data) {
        this.data = data;
    }
}
class DoubleList {
    public ListNode head;
    public ListNode last;

    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null || this.last == null) {
            this.head = node;
            this.last = node;
        }
        else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null || this.last == null) {
            this.head = node;
            this.last = node;
        }
        else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    public void display() {
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public boolean addIndex(int index,int data) {
        if(index == 0) {
            addFirst(data);
            return true;
        }
        if(index == size()) {
            return true;
        }
        if(index < 0 || index > size()) {
            return false;
        }
        //中间插入
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.prev.next = node;
        node.prev = cur.prev;
        node.next = cur;
        cur.prev = node;
        return true;
    }

    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

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

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                //删除的是头节点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                    return;
                }
                //删除的是中间节点或者是尾节点
                else {
                    cur.prev.next = cur.next;
                    //删除的不是尾节点
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }
                    //删除的是尾节点
                    else {
                        this.last = cur.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                //删除的是头节点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                    return;
                }
                //删除的是中间节点或者是尾节点
                else {
                    cur.prev.next = cur.next;
                    //如果不是尾节点
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }
                    //是尾节点
                    else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    public void clear() {
        while(this.head != null) {
            ListNode cur = this.head.next;
            this.head.prev = null;
            this.head.next = null;
            this.head = cur;
        }
        this.last = null;

    }
}
