package collectionsframework;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 堆
 * 优先级队列
 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }


    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }

        /**
         * i:代表的是每一棵树的根节点
         */
        for (int i = (this.usedSize-1-1)/2; i >= 0; i--) {
            //是每一棵树都按照向下调整的方式进行调整
            AdjustDown(i,this.usedSize);
        }
    }

    public void AdjustDown(int root,int len) {
        int parent = root;
        int child = 2*parent + 1;
        while (child < len){
            if (child+1 < len
                    && this.elem[child] < this.elem[child+1]) {
                child = child + 1;//child是左右孩子的最大值下标
            }

                //child下标的值大于parent下标的值  -》 交换
            if (this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }
    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] +" ");
        }
        System.out.println();
    }

    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }

    public void pushHeap(int value){
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.usedSize] = value;
        this.usedSize++;
        //开始向上调整
        AdjustUp(this.usedSize-1);
    }

    private void AdjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public void popHeap() {
        if (isEmpty()) {
            return;
        }
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;
        AdjustDown(0,this.usedSize);
    }

    public void heapSort() {
        int end = this.usedSize-1;
        while (end > 0) {
            int tmp = this.elem[end];
            this.elem[end] = this.elem[0];
            this.elem[0] = tmp;
            AdjustDown(0,end);
            end--;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(27);
        queue.offer(10);
        queue.offer(30);
        queue.offer(20);
        queue.offer(6);
        queue.offer(60);
        System.out.println(queue.peek());
        /*Map<String,Integer> map = new HashMap<>();
        map.put("kobe",2);
        map.put("kobe",2);
        map.put("kobe",2);
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }*/
    }

}
