package sort;

import java.util.Arrays;

public class TestSort1 {
    /**
     * 直接插入排序
     * 时间复杂度最好：O(n)
     * 时间复杂度最坏：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
/*        int i = 1;
        int j = i-1;
        while (i < arr.length) {
            int tmp = arr[i];
            while (j >= 0) {
                if(arr[j] < tmp) {
                    break;//前面的数据已经有序
                }else {
                    arr[j+1] = arr[j];
                    j--;
                }
            }
            arr[j+1] = tmp;
            i++;
            j = i -1;
        }*/
    }

    /**
     * 希尔排序
     * 时间复杂度最好：O(n)
     * 时间复杂度最坏：O(n^1.3) -- O(n^1.5)
     * 空间复杂度：O(1)
     * @param arr
     * @param gap
     */
    private static void shell(int[] arr,int gap) {
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i-gap; j >= 0; j -= gap) {
                if (arr[j] > tmp) {
                    arr[j+gap] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }
    public static void shellSort(int[] arr) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(arr,drr[i]);
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    /**
     * 向下调整
     * @param arr
     * @param root
     * @param len
     */
    public static void adjustDown(int[] arr,int root,int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            if (child+1 < len && arr[child] < arr[child+1]) {
                child++;
            }
            //child 保存的是最大值的下标
            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                //判断child下面还有没有孩子
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public static void createHeap(int[] arr) {
        for (int i = (arr.length-1-1)/2; i >= 0; i--) {
            adjustDown(arr,i,arr.length);
        }
    }


    /**
     * 堆排
     *
     * 时间复杂度：O(n*log2n)
     * 空间复杂度：O(1)
     * 建堆的时间复杂度：O(n*log2n)
     * 一次调整的时间复杂度：O(log2n)
     * @param arr
     */
    public static void heapSort(int[] arr) {
        createHeap(arr);
        int end = arr.length-1;
        while (end > 0) {
            int tmp = arr[end];
            arr[end] = arr[0];
            arr[0] = tmp;
            adjustDown(arr,0,end);
            end--;
        }
    }


    public static void main(String[] args) {
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(arr));
        System.out.println("==================");
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
        /*int[] arr = {9,5,3,10,2,6,7,1,8,4};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));*/
    }
}
