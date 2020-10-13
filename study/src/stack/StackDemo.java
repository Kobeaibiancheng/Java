package stack;

import java.util.Stack;

class TwoStacksImQueue<T>{
    Stack<T> stack1;
    Stack<T> stack2;

    public TwoStacksImQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    //出队
    public T pop() {
        if (this.stack2.empty()) {
            while (!this.stack1.empty()) {
                this.stack2.push(this.stack1.pop());
            }
            return this.stack2.pop();
        }else {
            return this.stack2.pop();
        }
    }
    //入队
    public void push(T x) {
        this.stack1.push(x);
    }


}
public class StackDemo {
    public static void main(String[] args) {
        TwoStacksImQueue<Integer> stacksImQueue = new TwoStacksImQueue<>();
        stacksImQueue.push(1);
        stacksImQueue.push(2);
        stacksImQueue.push(3);
        int ret = stacksImQueue.pop();
        System.out.println(ret);
        /*Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int ret = stack.peek();
        System.out.println(ret);
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.size());*/
    }
}
