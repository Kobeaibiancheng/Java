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

    /**
     * 希尔排序：是直接插入排序的优化，将待排的数据进行分组优化，每一组分别进行直接插入排序
     * 时间复杂度最好：O(n)
     * 时间复杂度最坏：O(n^1.3 - O(n^1.5))
     * 空间复杂度：O(1)
     * 稳定性：不稳定排序
     * @param arr
     * @param gap
     */
    private static void shell(int[] arr,int gap) {
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i-gap; j >= 0 ; j-=gap) {
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
    public static void main(String[] args) {
        int[] arr = {4,3,6,8,2,1,9,5,10,7};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println("===========================================");
        System.out.println(Arrays.toString(arr));
    }
}
