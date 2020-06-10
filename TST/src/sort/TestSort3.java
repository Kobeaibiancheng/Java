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


    /**
     * 归并排序:  分治思想
     *时间复杂度：O(n*log2n)
     *空间复杂度：O(n)
     * 稳定性：稳定的
     *
     * 递归写法
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        mergeSortInternal(arr,0,arr.length-1);
    }

    private static void mergeSortInternal(int[] arr,int left,int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortInternal(arr,left,mid);
            mergeSortInternal(arr,mid+1,right);
            //合并
            merge(arr,left,mid,right);
        }


    }

    private static void merge(int[] arr,int left,int mid,int right) {
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


    /**
     * 归并排序
     * 非递归
     * @param
     */
    /*public static void mergeSort(int[] arr) {
        for (int i = 1; i < arr.length; i *= 2) {
            merge(arr,i);
        }
    }
    //gap代表每个归并段的数据
    public static void merge(int[] arr,int gap) {

        int[] tmpArr = new int[arr.length];
        int k = 0;//下标

        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = (s2 + gap - 1) < arr.length ? s2 + gap - 1 : arr.length-1;

        while (s2 < arr.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (arr[s1] <= arr[s2]) {
                    tmpArr[k++] = arr[s1++];
                }else {
                    tmpArr[k++] = arr[s2++];
                }
            }

            while (s1 <= e1) {
                tmpArr[k++] = arr[s1++];
            }

            while (s2 <= e2) {
                tmpArr[k++] = arr[s2++];

            }

            s1 = e2 + 1;
            e1 = s1 + gap -1;
            s2 = e1 + 1;
            e2 = (s2 + gap - 1) < arr.length ? s2 + gap - 1 : arr.length-1;

        }
        //判断是不是还有一个归并段，且这个归并段是 s1 那一段
        while (s1 <= arr.length-1) {
            tmpArr[k++] = arr[s1++];
        }
        for (int i = 0; i < tmpArr.length; i++) {
            arr[i] = tmpArr[i];
        }
    }*/

    public static void main(String[] args) {
        int[] arr = {4,3,6,8,2,1,9,5,10,7};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("===========================================");
        System.out.println(Arrays.toString(arr));
    }
}
