package sort;

import java.util.Arrays;

public class TestSort3 {
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
            int j = 0;
            int tmp = arr[i];
            for (j = i-1; j >=0 ; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定排序
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度最好：O(n)
     * 时间复杂度最坏：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定排序
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]){
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
        int[] arr = {4,3,6,8,2,1,9,5,10,7};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("===========================================");
        System.out.println(Arrays.toString(arr));
    }
}
