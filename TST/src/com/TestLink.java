package com;

public class TestLink<T> {
    static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public Node<T> head = null;

    public void insertHead(T data) {
        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = head;
            this.head = node;
        }
    }

    public void insertTail(T data) {
        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head.next = node;
        } else {
            Node<T> cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void print() {
        Node<T> cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
    }

    public void printNewHead(Node<T> newHead) {
        Node<T> cur = newHead;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
    }

}
