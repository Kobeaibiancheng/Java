class MyListNode {
    public int data;
    MyListNode next;
    public MyListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
class MySingleList {
    MyListNode head;

    public MySingleList() {
        this.head = null;
    }

    public void dispaly() {
        MyListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //头插法
    public void addFirst(int data) {
        MyListNode node = new MyListNode(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next =this.head;
        this.head = node;
    }
    //尾插法
    public void addLast(int data) {
        MyListNode node = new MyListNode(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        MyListNode cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    /**
     * 找到index-1节点，并且返回该节点的引用
     * @param index
     * @return
     */
    private MyListNode search(int index) {
        MyListNode cur = this.head;
        for (int i = 0; i < index-1; i++) {
            cur = cur.next;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标    
    public boolean addIndex(int index,int data) {
        MyListNode node = new MyListNode(data);
        if(index == 0) {
            addFirst(data);
            return true;
        }
        MyListNode prev = search(index);
        if(prev == null) {
            System.out.println("未找到index下标");
            return false;
        }
        else {
            node.next = prev.next;
            prev.next = node;
            return true;
        }
    }
    //查找是否包含关键字key是否在单链表当中    
    public boolean contains(int key) {
        MyListNode cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    //找到要删除的节点的前驱
    private MyListNode searchPrev(int key) {
        MyListNode prev = this.head;
        while(prev.next != null) {
            if(prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点    
    public void remove(int key) {
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        MyListNode prev = searchPrev(key);
        if(prev != null) {
            MyListNode del = prev.next;
            prev.next = del.next;
        }
        else {
            System.out.println("没有该节点");
        }
    }

    //删除所有节点为key的值
    public void removeAllKey(int key) {
        MyListNode prev = this.head;
        MyListNode cur = this.head.next;
        while(cur != null) {
            if(prev.next.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //得到单链表的长度    
    public int size() {
        MyListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //清空单链表
    public void clear() {
        MyListNode cur = this.head;
        while(cur != null) {
            this.head = cur.next;
            cur = cur.next;
        }
    }

}
