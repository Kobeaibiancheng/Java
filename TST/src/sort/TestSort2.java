package sort;

import java.util.Arrays;

public class TestSort2 {


    /**
     * 快速排序
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int partion(int[] arr,int start,int end) {
        int tmp = arr[start];
        while (start < end){
            while ((start < end) && arr[end] >= tmp) {
                end--;
            }
            if (start >= end) {
                break;
            }else {
                arr[start] = arr[end];
            }
            while ((start < end) && arr[start] <= tmp) {
                start++;
            }
            if (start >= end) {
                break;
            }else {
                arr[end] = arr[start];
            }
        }
        arr[start] = tmp;
        return start;
    }
/*    public static void insertSort(int[] arr,int low,int high) {
        for (int i = low; i < high; i++) {
            int tmp = arr[i];
            int j = low-1;
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }*/
    public static void quick(int[] arr,int low,int high) {
        if(low < high) {
            //优化
            /*if (high-low+1 < 100) {
                //insertSort(arr,low,high);待排数据越少，直接插入排序效率越高
                return;
            }*/
            //1.将待排序列分为两部分
            int pivot = partion(arr,low,high);
            //2.递归，左，右
            quick(arr,low,pivot-1);
            quick(arr,pivot+1,high);
        }
    }
    public static void quickSort(int[] arr,int low,int high) {
        quick(arr,0,arr.length-1);
    }


    /**
     * 冒泡排序
     * 时间复杂度最坏：O(n^2)
     * 时间复杂度最好：O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,6,2,1,8,7,9,10};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
