package com;

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
        }
        else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(cur == null) {
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

    public int getLength() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    public ListNode searchPrev(int Index) {
        ListNode prev = this.head;
        for (int i = 0; i < Index-1; i++) {
            prev = prev.next;
        }
        return prev;
    }
    public boolean addIndex(int Index,int data) {
        if(Index > getLength() || Index < 0) {
            return false;
        }
        else {
            ListNode prev = searchPrev(Index);
            if(prev != null) {
                ListNode node = new ListNode(data);
                node.next = prev.next;
                prev.next = node;
                return true;
            }
            else {
                return false;
            }
        }
    }

    public ListNode reverse() {
        if (this.head == null) {
            return null;
        }
        //newHead表示反转后单链表新的头
        ListNode newHead = null;
        //prev表示将要反转的节点的前驱
        ListNode prev = null;
        //cur表示将要反转的节点
        ListNode cur = this.head;
        while (cur != null) {
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
}