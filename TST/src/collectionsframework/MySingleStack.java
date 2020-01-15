package collectionsframework;

/**
 * 单链表栈
 */
class Node {
    public int data;
    public Node next;

    public Node (int data) {
        this.data = data;
        this.next = null;
    }
}

public class MySingleStack {
    public Node head;

    //入栈
    public int push(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return this.head.data;
        }
        node.next = this.head;
        this.head = node;
        return this.head.data;
    }
    //出栈
    public int pop() {
        int ret = this.head.data;
        this.head = this.head.next;
        return ret;
    }

    //获得栈顶元素
    public int peek() {
        return this.head.data;
    }
}
