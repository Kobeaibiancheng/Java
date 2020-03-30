package sort;


import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int pivot = partion(arr,left,right);
            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }
    private static int partion(int[] arr,int left,int right) {
        int i = left;
        int j = right;
        int pivot = arr[left];
        while (i < j) {

            //找到右边小于 pivot 的值
            while (i < j && arr[j] >= pivot) {
                j--;
            }

            //找到左边大于 pivot 的值
            while (i < j && arr[i] <= pivot) {
                i++;
            }

            //i j 未相遇    -》 交换 下标i和j的值
            if (i < j) {
                /*int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;*/
                swap(arr,i,j);
            }
        }
        //i j 相遇   -》  交换arr[i] 和基准 pivot(arr[left])
        swap(arr,i,left);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {6,1,2,7,9,3,4,5,10,8};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
