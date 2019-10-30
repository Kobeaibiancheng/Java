import java.util.Arrays;

public class Test {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean bool = true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    bool = false;
                }
            }
            if(bool) {
                return;
            }
        }

    }
    //二分查找常规写法
/*    public static int binarySearch(int[] arr,int key) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(arr[mid] == key) {
                return mid;
            }
            else if(arr[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid +1;
            }
        }
        return -1;
    }*/
    //二分查找递归法实现
    public static int binarySearch(int[] arr,int key,int left,int right) {
        if(left > right) {
            return -1;
        }
        int mid = (left+right)>>>1;
        if(arr[mid] == key) {
            return mid;
        }
        else if(arr[mid] > key) {
            return binarySearch(arr,key,left,mid-1);
        }
        else {
            return binarySearch(arr,key,mid+1,right);
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,6,4,7,9,6,5,10,8};
        int left = 0;
        int right = arr.length-1;
        bubbleSort(arr);
        int ret = binarySearch(arr,5,left,right);
        System.out.println(ret);
        System.out.println(Arrays.toString(arr));
    }
}
