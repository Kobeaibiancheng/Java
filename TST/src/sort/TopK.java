package sort;

import java.util.Arrays;

/**
 * 海量数据  最大的n个数或最小的n个数
 * 求最大的k个数，   求最小的k个数
 * 建大小为k的小堆，  建大小为k个大堆
 */
public class TopK {

    //堆排
    public static void heapSort(int[] arr) {
        createHeap(arr);
        int end = arr.length-1;
        while (end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjustLargeDown(arr,0,end);
            end--;
        }
    }

    /**
     * 建堆
     * 时间复杂度：O(n*log2n)
     * @param arr
     */
    private static void createHeap(int[] arr) {
        for (int i = (arr.length-1-1)/2; i >= 0; i--) {
            adjustLargeDown(arr,i,arr.length);
        }
    }



    //向下调整
    private static void adjustLargeDown(int[] arr,int i,int len) {
        int parent = i;
        int child = parent*2+1;
        while (child < len) {
            if (child+1 < len && arr[child+1] > arr[child]) {
                child = child+1;
            }
            //child 保存的是孩子中最大值得下标
            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }
    }
    /**
     * 海量数据中最小的k个
     * @param arr
     * @param k
     */
    public static int[] largeKHeap(int[] arr,int k) {
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {
            kHeap[i] = arr[i];
        }
        /**
         * 建大小为k的大堆 -》 求最小得k个数
         */
        for (int i = (k-1-1)/2; i >= 0; i--) {
            adjustLargeDown(kHeap,i,k);
        }
        /**
         * 从下标为k依次开始和堆顶元素比较，小于堆顶元素 交换 重新调整
         */
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                adjustLargeDown(kHeap,0,k);
                //k--;
            }
        }
        return kHeap;
    }




    private static void adjustSmallDown(int[] arr,int i,int k) {
        int parent = i;
        int child = 2*parent + 1;
        while(child < k) {
            if (child+1 < k && arr[child+1] < arr[child]) {
                child = child+1;
            }

            //child 下标保存的是最小的值
            if (arr[child] < arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                parent = child;
                child = 2*parent + 1;
            }else {
                break;
            }
        }
    }
    /**
     * 海量数据中最大的k个
     * @param arr
     * @param k
     * @return
     */
    public static int[] smallKHeap(int[] arr,int k) {
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {
            kHeap[i] = arr[i];
        }

        //建立大小为k的小堆
        for (int i = (k-1-1)/2; i >= 0; i--) {
            adjustSmallDown(kHeap,i,k);
        }

        /**
         * 从下标k开始和堆顶比较，大于堆顶元素交换并且调整
         */
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > kHeap[0]){
                kHeap[0] = arr[i];
                adjustSmallDown(kHeap,0,k);
            }
        }
        return kHeap;
    }



    public static void main(String[] args) {
        int[] arr = {10,8,1,9,3,6,4,2,5,7};
        int k = 4;
        /*
            最小的k个数   大堆
         */
        int[] largeKHeap = largeKHeap(arr,k);
        Arrays.sort(largeKHeap);
        System.out.println(Arrays.toString(largeKHeap));


        System.out.println("============================");

        /*
            最大的k个数   小堆
         */
        int[] smallKHeap = smallKHeap(arr,k);
        Arrays.sort(smallKHeap);
        System.out.println(Arrays.toString(smallKHeap));
        /*Queue<Integer> queue = new PriorityQueue<>(4);
        for (int i = 0; i < queue.size(); i++) {
            queue.offer(arr[i]);
        }

        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));*/
    }
}
