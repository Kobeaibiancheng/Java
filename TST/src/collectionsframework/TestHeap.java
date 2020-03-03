package collectionsframework;

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

    private void AdjustDown(int root, int len) {

    }


    public static void main(String[] args) {
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
