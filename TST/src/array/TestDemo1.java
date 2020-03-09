package array;


import java.util.Arrays;
import java.util.Scanner;

public class TestDemo1 {

    /**
     * 压缩字符串
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        int write = 0;
        int anchor = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;

    }
    /**
     * 寻找左侧边界的二分搜索
     * @param nums
     * @param target
     * @return
     */
    private static int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
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
        if (left == nums.length) return -1;
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
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

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
        if (left == 0) return -1;
        return nums[left-1] == target ? (left-1) : -1;
    }
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums,target),right_bound(nums,target)};
    }


    private static int binarySearch(int[] nums,int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找先找到target的下标，如果未找到直接返回-1
     * 找到target的下标后前后依次遍历来确定区间
     * @param nums
     * @param target
     * @return
     */
    /*public static int[] searchRange(int[] nums, int target) {
        int ret = binarySearch(nums,target);
        if (ret == -1) {
            return new int[]{-1,-1};
        }else {
            int i = ret;
            while (i > 0 && nums[i-1] == target) {
                i--;
            }
            while (ret < nums.length-1 && nums[ret+1] == target) {
                ret++;
            }
            return new int[]{i,ret};
        }
    }*/



    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * @param nums
     * @param target
     * @return
     */
    //自己写的垃圾代码
   /* public static int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[i] == target) {
                j = i+1;
                while (j < nums.length && nums[j] == target) {
                    j++;
                }
                return new int[] {i,j-1};
            }else {
                i++;
                j++;
            }
        }
        return new int[] {-1,-1};
    }*/
    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
    /**
     * 第三大的数
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0]:nums[1];
        }
        int firstMax = nums[0];
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (firstMax == nums[i] || secondMax == nums[i] || thirdMax == nums[i]) {
                continue;
            }
            if (nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            }else if (nums[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            }else if (nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
        }
        if (thirdMax == Long.MIN_VALUE){
            return firstMax;
        }
        return (int)thirdMax;
    }
    /**
     * 数组表示一个非负整数   加一
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;

    }
    /**
     * 寻找数组的中心索引
     * @param nums
     * @return
     */
    public static int piovtIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == leftSum * 2) {
                return i;
            }else {
                leftSum += nums[i];
            }
        }
        return -1;

    }
    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length-1;
        //保证i下标位置存放的是偶数
        while (i < j) {
            if (A[i]%2 > A[j]%2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i]%2 == 0) {
                i++;
            }
            if (A[j]%2 == 1) {
                j--;
            }
        }
        return A;
    }

    //时间复杂度：O(n) 遍历两边数组
    //空间复杂度;O(n)
    /*public static int[] sortArrayByParity(int[] A) {
        int[] ret = new int[A.length];
        int t = 0;
        //第一次放入偶数
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2 == 0) {
                ret[t++] = A[i];
            }
        }
        //第二次放入奇数
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2 != 0) {
                ret[t++] = A[i];
            }
        }
        return ret;
    }*/


    //时间复杂度：O(n)   双指针只遍历了一遍数组 一个指向数组头 另一个指向数组尾
    //空间复杂度：O(n)
    /*public static int[] sortArrayByParity(int[] A) {
        int[] ret = new int[A.length];
        int p1 = 0;
        int p2 = A.length-1;
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2 == 0) {
                ret[p1] = A[i];
                p1++;
            }else {
                ret[p2] = A[i];
                p2--;
            }
        }
        return ret;
    }*/

    /*public static int[] sortArrayByParity(int[] A) {
        for (int i = 0; i <  A.length; i++) {
            if (A[i]%2 == 0) {
                int tmp = A[i];
                for (int j = i-1; j >= 0; j--) {
                    A[j+1] = A[j];
                }
                A[0] = tmp;
            }
        }
        return A;
    }*/


    /**
     * 将每一个元素平方后
     * 进行排序
     * @param A
     * @return
     */
    /*public static int[] sortedSquares(int[] A) {
        int[] ret = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ret[i] = A[i] * A[i];
        }
        Arrays.sort(ret);
        return ret;
    }*/


    /**
     * 找到分界点将数组分为两个有序数组，负数数组和非负数组
     * 每个元素平方和后，负数数组是按照降序排列，非负数组按照升序排列
     * 双指针分别指向平方和最小的元素，按照合并两个有序数组的方法合并两个数组
     * @param A
     * @return
     */
    public static int[] sortedSquares(int[] A) {
        int[] ret = new int[A.length];
        int p1 = 0;
        while (p1 < A.length && A[p1] < 0) {
            p1++;
        }
        int p2 = p1-1;
        int i = 0;

        //-4  -2   0   1   3  5
        //        p2  p1
        while (p2 >= 0 && p1 < A.length) {
            if (A[p1] * A[p1] < A[p2] * A[p2]) {
                ret[i] = A[p1] * A[p1];
                p1++;
            }else {
                ret[i] = A[p2] * A[p2];
                p2--;
            }
            i++;
        }
        while (p1 < A.length) {
            ret[i++] = A[p1] * A[p1];
            p1++;
        }
        while (p2 >= 0) {
            ret[i++] = A[p2] * A[p2];
            p2--;
        }
        return ret;
    }
    public static int findUnsortedSubarray(int[] nums) {
        int[] nums_sort = nums.clone();
        Arrays.sort(nums_sort);
        int start = nums_sort.length;
        int end = 0;
        for (int i = 0; i < nums_sort.length; i++) {
            if (nums_sort[i] != nums[i]) {
                start = Math.min(start,i);
                end = Math.max(end,i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    /*public static List<List<Integer>> subsets(int[] nums) {
        String name = "1";
        AbstractList
        ArrayList
    }*/



    //数组中的逆序对
    public static int InversePairs(int[] array,int n) {
        if (array == null || n == 0) {
            return 0;
        }
        return mergeSortRecursion(array,0,n-1);
    }
    private static int mergeSortRecursion(int[] array, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l+r)/2;
        //逆序对数 = 左边数组的逆序对数 + 右边数组逆序的对数 + 左右结合成新数组中的逆序对数
        return mergeSortRecursion(array,l,mid) + mergeSortRecursion(array,mid,r)
                + merge(array,l,mid,r);
    }
    private static int merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid+1;
        int inverseNum = 0;//新增，用来累加数组逆序对
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[index++] = array[i++];

            }else {
                //当前一个数组元素大于后一个数组元素时，累加逆序对
                // s[i] > s[j] 推导出 s[i]...s[mid] > s[j]
                inverseNum += (mid - i + 1);
                temp[index++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = array[i++];
        }
        while (j <= right) {
            temp[index++] = array[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            array[left++] = temp[k];
        }
        return inverseNum;
    }


    //n个数里出现次数大于等于n/2的数
    public static void largestOfNums() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }

        /**
         * 保存两个值：一个是数组中的数字，一个是该数字出现的次数
         * 当我们遍历到下一个数字的时候，如果和我们保存的数字相同，那么次数加一
         * 如果下一个数字和我们之前保存的数字不同，则次数减一
         * 如果次数为0，那么我们需要保存下一个数字，并把次数更改为一
         * 由于我们要找的数字出现的次数比其他数字出现的次数之和还要多，那么要找的
         * 数字肯定是最后一次把次数设为一时对应的数字
         *
         */
        //保存数字
        int num = arr[0];
        //保存次数
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == num) {
                count++;
            }else if(count > 0) {
                count--;
            }else{
                num = arr[i];
            }
        }
        System.out.println(num);
    }

    //牛客：计算糖果
    public static void getNumOfCandy() {
        Scanner sc = new Scanner(System.in);
        int y1 = sc.nextInt();
        int y2 = sc.nextInt();
        int y3 = sc.nextInt();
        int y4 = sc.nextInt();
        //通过四个方程解出三个未知数
        double a = (y1+y3)/2;
        double b = (y2+y4)/2;
        double c = (y4-y2)/2;
        //带回去验证是否符合四个方程  符合为正确，不符合为No
        if(a-b == y1 && b-c == y2 && a+b == y3 && b+c == y4){
            System.out.println((int)a+ " "+(int)b +" "+ (int)c);
        }else{
            System.out.println("No");
        }
    }


    public static void main(String[] args) {
        char[] arr = {'a','a','b','c','c'};
        System.out.println(compress(arr));
        /*int[] arr = {1,2,2};
        System.out.println(Arrays.toString(searchRange(arr,2)));*/
        //System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}
