package list;


import java.util.Scanner;

class Node {
    char ch;
    Node next;

    /*public Node(char ch) {
        this.ch = ch;
    }*/
}
public class Demo1 {
    public static void main(String[] args) {
        Node head = createLinkList();
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.ch + " ");
            cur = cur.next;
        }
    }

    /**
     * 带头节点的建单链表   （头节点不存放数据）
     * @return
     */
    private static Node createLinkList() {
        Scanner sc = new Scanner(System.in);
        Node head = new Node();
        head.next = null;

        Node cur = null;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            cur = head.next;
            while (cur != null) {
                if (cur.ch == ch){
                    break;
                }
                cur = cur.next;
            }
            if (cur == null) {
                Node node = new Node();
                node.ch = ch;
                node.next = head.next;
                head.next = node;
            }
        }
        return head;
    }
}
