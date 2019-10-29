
import java.util.Arrays;

public class List {
    private int[] arr;
    private int usefulElem;
    private final int CAPACITY = 5;
    //构造方法
    public List() {
        this.arr = new int[CAPACITY];
        this.usefulElem = 0;
    }

    public void printList() {
        for (int i = 0; i < this.usefulElem; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private boolean isFull() {
        return this.usefulElem == this.arr.length;
    }
    public void addPos(int pos,int data) {
        //扩容
        if(isFull()) {
            this.arr = Arrays.copyOf(this.arr,this.arr.length*2);
            System.out.println("扩容成功");
        }
        //输入是否合法
        if(pos < 0 || pos > this.usefulElem) {
            System.out.println("添加错误");
            return;
        }
        //挪数据
        for (int i = this.usefulElem-1; i >= pos; i--) {
            this.arr[i+1] = this.arr[i];
        }
        this.arr[pos] = data;
        this.usefulElem++;
    }

    public int search(int elem) {
        for (int i = 0; i < this.usefulElem; i++) {
            if(elem == this.arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos) {
        if(pos >= 0 && pos < this.usefulElem) {
            return this.arr[pos];
        }
        System.out.println("没有pos这个位置");
        return -1;
    }

    public void setPos(int pos,int data) {
        if(pos >= 0 && pos < this.usefulElem) {
            this.arr[pos] = data;
        }
    }

    public void remove(int data) {
        int ret = search(data);
        if(ret == -1) {
            System.out.println("找不到这个元素");
            return;
        }
        for (int i = ret; i < this.usefulElem-1; i++) {
            this.arr[i] = this.arr[i+1];
        }
        this.usefulElem--;
    }

    public int listLength() {
        return this.usefulElem;
    }

    public void clearList() {
        this.usefulElem = 0;
    }
}
