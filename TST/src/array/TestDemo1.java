package array;


public class TestDemo1 {
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
    public static void main(String[] args) {
        int[] arr = {3,1,4,4};
        System.out.println(thirdMax(arr));
        //System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}