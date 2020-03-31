package sort;


import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int pivot = partion(arr,left,right);
            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }
    // Hoare 法:
    /*private static int partion(int[] arr,int left,int right) {
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
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                swap(arr,i,j);
            }
        }
        //i j 相遇   -》  交换arr[i] 和基准 pivot(arr[left])
        swap(arr,i,left);
        return i;
    }*/

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    //挖坑法 ：
    /*private static int partion(int[] arr,int left,int right) {
        int i = left;
        int j = right;
        int pivot = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        return i;
    }*/

    //前后遍历法：
    private static int partion(int[] arr, int left, int right) {
        int d = left + 1;
        int pivot = arr[left];
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, d);
                d++;
            }
        }
        swap(arr, d - 1, left);
        return d - 1;
    }



    //非递归分治
    public static void quickSort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                continue;
            }
            int pivotIndex = partion(arr, left, right);
            stack.push(right);
            stack.push(pivotIndex + 1);
            stack.push(pivotIndex - 1);
            stack.push(left);
        }
    }


    public static void main(String[] args) {
        int[] arr = {6,1,2,7,9,3,4,5,10,8};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
