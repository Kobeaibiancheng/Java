package collectionsframework;

import java.util.Arrays;

/**
 * 顺序栈
 * 先进后出
 * @param <T>
 */
public class MyStack<T> {
    public T[] elem;
    public int top;//下标

    public MyStack() {
        this.elem = (T[]) new Object[10];
        this.top = 0;
    }
    private boolean isFull() {
        return this.top == this.elem.length;
    }
    public void push(T value) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);//二倍扩容
            System.out.println("扩容成功");
        }
        this.elem[this.top] = value;
        this.top++;
    }
    private boolean isEmpty() {
        return this.top == 0;
    }
    //出栈
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T tmp = this.elem[this.top-1];
        this.top--;
        return tmp;
    }
    //获得栈顶元素，但不出栈
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return this.elem[this.top-1];
    }
}

class MyListStack<T>{
    //定义一个内部类 就可以直接使用类型参数
    class Node{
        T data;
        Node next;
    }

    private Node first;
    private int size;
    //构造方法
    public MyListStack() {
    }
    //入栈
    public void push(T data) {
        Node oldfirst = first;
        first = new Node();
        first.data = data;
        first.next = oldfirst;
        size++;
    }
    //出栈
    public boolean pop() {
        T data = first.data;
        first = first.next;
        size--;
        return true;
    }
    //获得栈顶元素
    public T peek(){
        return first.data;
    }
    public int size() {
        return size;
    }
}