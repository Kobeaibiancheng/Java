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
            }else if (arr[mid] == k){
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
    /**
     * 寻找左侧边界的二分搜索
     * @param nums
     * @param target
     * @return
     */
    public static int left_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        // target 比所有数都大
        if (left == nums.length){
            return -1;
        }
        // 类似之前算法的处理方式
        return nums[left] == target ? left : -1;
    }

    /**
     * 寻找右侧边界的二分搜索
     * @param nums
     * @param target
     * @return
     */
    private static int right_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) {
            return -1;
        }
        return nums[left-1] == target ? (left-1) : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,7,7,8,9,10};
        System.out.println(left_bound(arr,7));
    }
}
