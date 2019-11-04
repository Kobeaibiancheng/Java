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
        node.next = head;
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
    public MyListNode search(int index) {
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

}
