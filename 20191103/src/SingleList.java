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

}
