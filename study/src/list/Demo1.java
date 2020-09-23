package list;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Node {
    int data;
    Node next;

    /*public Node(char ch) {
        this.ch = ch;
    }*/
}
public class Demo1 {
    /**
     * 逆置前k个元素，并且移动到数组的后端
     * @param arr
     * @param k
     * @param n
     */
    /*public static void reverseArray(int[] arr,int k,int n){
        // 1 2 3 4 5 6 7  -》 5 6 7 4 3 2 1
        int i = 0;
        int j = n-1;
        //整体逆置 7 6 5 4 3 2 1
        for (i = 0,j = n-1; i < j; i++,j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        //部分逆置 5 6 7 4 3 2 1
        for (i = 0,j = n-k-1; i < j; i++,j--) {
            //i == 0
            //j == n-k-1   表示除了k个元素剩余元素中最大的下标
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }*/
    public static void reverseArray(int[] arr,int k,int n){
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
    }

    public static void reverseArrayOther(int[] arr,int k,int n){
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
    }
    public static void reverse(int[] arr,int left,int right){
        int i = left;
        int j = right;
        for (i = left,j = right; i < j; i++,j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        /*int[] arr1 = {1,2,3,4,5,6,7,8};
        int[] arr2 = {2,4,6,8,10};
        int[] arr = new int[arr1.length+arr2.length];
        mergeArray(arr1,arr1.length,arr2,arr2.length,arr);
        System.out.println(Arrays.toString(arr));
        reverseArrayOther(arr,4,8);
        System.out.println(Arrays.toString(arr));
        Node head = createLinkList();
        printLink(head);*/
        Node newHead = new Node();
        Node headA = new Node();
        Node a1 = new Node();
        Node a2 = new Node();
        Node a3 = new Node();
        Node a4 = new Node();
        headA.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        a1.data = 1;
        a2.data = 2;
        a3.data = 4;
        a4.data = 6;
        //printLink(headA.next);
        Node headB = new Node();
        Node b1 = new Node();
        Node b2 = new Node();
        Node b3 = new Node();
        Node b4 = new Node();
        Node b5 = new Node();
        Node b6 = new Node();
        headB.next = b1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b1.data = 3;
        b2.data = 5;
        b3.data = 7;
        b4.data = 8;
        b5.data = 9;
        b6.data = 10;
        mergeLinkHead(headA,headB,newHead);

        printLink(newHead);

    }


    /**
     * 合并单链表 头插法
     * @param headA
     * @param headB
     * @param newHead
     */
    public static void mergeLinkHead(Node headA,Node headB,Node newHead){
        Node p1 = headA.next;
        Node p2 = headB.next;
        Node cur = newHead;
        while (p1 != null && p2 != null) {
            
        }

    }
    /**
     * 合并两个单链表   尾插法
     * @param headA
     * @param headB
     * @param newHead
     */
    public static void mergeLinkEnd(Node headA,Node headB,Node newHead){
        Node p1 = headA.next;
        Node p2 = headB.next;
        Node cur = newHead;
        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                cur.next = p1;
                p1 = p1.next;
            }else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
    }
    /**
     * 合并有序的顺序表 （默认升序）
     * @param arr1
     * @param m
     * @param arr2
     * @param n
     * @param arr
     */
    public static void mergeArray(int[] arr1,int m,int[] arr2,int n,int[] arr){
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n){
            if (arr1[i] < arr2[j]){
                arr[index++] = arr1[i++];
            }else {
                arr[index++] = arr2[j++];
            }
        }
        while (i < m) {
            arr[index++] = arr1[i++];
        }
        while (j < n) {
            arr[index++] = arr2[j++];
        }
    }

    /**
     * 两个带头链表的第一个公共结点
     * @param headA
     * @param headB
     * @return
     */
    public static Node findFirstCommon(Node headA,Node headB) {
        Node cur1 = headA.next;
        Node cur2 = headB.next;
        int lenA = 0;
        int lenB = 0;
        while (cur1 != null) {
            cur1 = cur1.next;
            lenA++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            lenB++;
        }

        for (cur1 = headA.next; lenA > lenB; lenA--){
            cur1 = cur1.next;
        }
        for (cur2 = headB.next; lenB > lenA; lenB--){
            cur2 = cur2.next;
        }
        while (cur1 != null && cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 带头节点的建单链表   （头节点不存放数据）
     * @return
     */
    /*private static Node createLinkList() {
        Scanner sc = new Scanner(System.in);
        Node head = new Node();
        head.next = null;

        Node cur = null;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            cur = head.next;
            while (cur != null) {
                if (cur.data == ch){
                    break;
                }
                cur = cur.next;
            }
            if (cur == null) {
                Node node = new Node();
                node.data = ch;
                node.next = head.next;
                head.next = node;
            }
        }
        return head;
    }*/

    /**
     * 带头节点的建单链表 用HashSet不能存放相同的数据特性  存放字母不重复的结点  （头节点不存放数据）
     * @return
     */
    public static Node createLinkList() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Character> set = new HashSet<>();//用于判断是否包含重复的字母
        Node head = new Node();
        Node cur = head;
        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            if (!set.contains(ch)){      //不包含：将链表连接
                Node node = new Node();
                node.data = ch;
                cur.next = node;
                cur = node;
            }
            set.add(ch);
        }
        return head.next;
    }
    public static void printLink(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }


}
