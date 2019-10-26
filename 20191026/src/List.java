import java.util.Arrays;

public class List {
    private int[] elem;
    private int usedSize;
    private final int CAPACITY = 10;
    public List() {
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }


    //打印顺序表
    public void disPlay(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
    }
    private boolean isFull() {
        return this.usedSize == CAPACITY;
    }

    public void add(int pos,int data) {
        if(isFull()) {
            //满了 -》 扩容
            System.out.println("满了，扩容成功");
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        if(pos < 0 || pos > this.usedSize) {
            return;
        }
        //挪数据
        for (int i = this.usedSize-1; i >= pos ; i--) {
                this.elem[i+1] = this.elem[i];
            }
            this.usedSize++;
            this.elem[pos] = data;
    }

    //查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }

    //获取pos位置的元素
    public int getPos(int pos) {
        if(pos >= 0 && pos < this.usedSize) {
            return this.elem[pos];
        }
        System.out.println("不合法");
        return -1;//没有pos位置
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(pos >= 0 && pos < this.usedSize) {
            this.elem[pos] = value;
        }
    }

    //删除一个数
    public void remove(int toRemove) {
        int ret = search(toRemove);
        if(ret == -1) {
            System.out.println("没有这个数");
            return;
        }
        for (int i = ret; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    //获取顺序表长度
    public int listLength() {
        return this.usedSize;
    }

    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}
