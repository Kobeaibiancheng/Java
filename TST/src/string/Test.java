package string;

public class Test {
    /**
     * 二分查找常规写法
     * @param arr
     * @param k
     * @return
     */
    public static int binarySearch(int[] arr,int k) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = left+(right-left)/2;
            //int mid = (left+right)>>>1
            if (arr[mid] < k) {
                left = mid + 1;
            }else if (arr[mid] > k) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     * @param arr
     * @param key
     * @param left
     * @param right
     * @return
     */
    public static int binarySearch(int[] arr,int key,int left,int right){
        if (left > right) {
            return -1;
        }
        int mid = (left+right)/2;
        if (arr[mid] == key) {
            return mid;
        }else if (arr[mid] > key) {
            return binarySearch(arr,key,left,mid-1);
        }else {
            return binarySearch(arr,key,mid+1,right);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr,0,0,arr.length-1));
    }
}
