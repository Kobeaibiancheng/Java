package programming;

import java.util.Arrays;

class SortDemo {
    public static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int pivot = partion(arr,left,right);
            quickSort(arr,left,right-1);
            quickSort(arr,pivot+1,right);
        }
    }

    public static int partion(int[] arr,int left,int right) {
        int i = left;
        int j = right;
        int pivot = arr[left];
        while (i < j) {
            //在左边找一个大于pivot的值
            while (i < j && arr[i] <= pivot) {
                i++;
            }

            //在右边找一个小于pivot的值
            while (i < j && arr[j] >= pivot) {
                j--;
            }

            if (i < j) {
                swap(arr,i,j);
            }
        }
        swap(arr,i,left);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,7,5,6,9,10};
        quickSort(arr,0,arr.length-1);
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));

    }
}
