package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2,3,1,6,4,8,9,7,10,5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void createHeap(int[] arr) {
        for (int i = (arr.length-1-1)/2; i >= 0; i--) {
            adjustDown(arr,i,arr.length);
        }
    }
    public static void adjustDown(int[] arr,int i,int len) {
        int parent = i;
        int child = parent*2+1;
        while(child < len) {
            if (child+1 < len && arr[child] < arr[child+1]) {
                child = child+1;
            }
            if (arr[child] > arr[parent]) {
                int tmp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tmp;
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }

        }
    }
    public static void heapSort(int[] arr) {
        createHeap(arr);
        int end = arr.length-1;
        while (end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;

            adjustDown(arr,0,end);
            end--;
        }
    }
}
