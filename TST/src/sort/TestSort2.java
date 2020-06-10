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


    /**
     * 归并排序
     * 分而治之
     * @param arr
     * @param left
     * @param right
     */
    /*public static void mergeSort(int[] arr,int left,int right) {
        if (left < right) {
            int mid = left + (right-left)/2;
            mergeSort(arr,left,mid);//将左边不断的分割，知道就剩一个元素，即有序
            mergeSort(arr,mid+1,right);//将右边不断的分割，知道就剩一个元素，即有序

            merge(arr,left,mid,right);//合并左右
        }
    }*/

    public static void merge(int[] arr, int left, int mid, int right) {
        int start1 = left;
        int start2 = mid+1;

        int[] tmpArr = new int[right-left+1];
        int i = 0;//tmpArr的索引

        while (start1 <= mid && start2 <= right) {
            if (arr[start1] <= arr[start2]) {
                tmpArr[i++] = arr[start1++];
            }else {
                tmpArr[i++] = arr[start2++];
            }
        }

        //循环退出后，有两种情况，一种是 start1 指向的还有剩余元素，另一种是 start2
        //指向的还有剩余元素
        while (start1 <= mid) {
            tmpArr[i++] = arr[start1++];
        }
        while (start2 <= right) {
            tmpArr[i++] = arr[start2++];
        }

        //tmpArr里存放是的有序的数据，现在需要将tmpArr里的数据放回到arr中
        for (int j = 0; j < tmpArr.length; j++) {
            arr[left + j] = tmpArr[j];
        }
    }

    public static void mergeSort(int[] arr) {
        //从1开始：将待排序数组分割成多个长度为1的子数组
        for (int i = 1; i < arr.length ; i *= 2) {
            for (int j = 0; j < arr.length; j = j+2*i) {
                int left = j;//要合并区间的起始下标
                int mid = j+i-1;//将带合并区间分为两个数组
                int right = mid+i;//要合并区间的末尾下标
                if (right > arr.length-1) {
                    right = arr.length-1;
                }
                if (mid > arr.length-1) {
                    continue;
                }
                //合并
                merge(arr,left,mid,right);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,1,4,3,5,6,7,9,10,8};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("=============================");
        //quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
