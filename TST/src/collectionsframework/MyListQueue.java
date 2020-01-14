package collectionsframework;

/**
 * 链式队列
 * 先进先出
 */
public class MyListQueue {
    class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public Node front;
    public Node rear;//尾
    public int usedSize;

    //入队
    public void offer(int data) {
        Node node = new Node(data);
        //第一次入队
        if (this.usedSize == 0) {
            this.front = node;
            this.rear = node;
        }else {
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize++;
    }
    //出队
    public int poll() {
        if (this.usedSize == 0) {
            throw new UnsupportedOperationException("队列为空");
        }
        int value = this.front.data;
        this.front = this.front.next;
        this.usedSize--;
        return value;
    }

    public int peek() {
        if (this.usedSize == 0) {
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }
}
