import java.util.Arrays;

/**
 * Arrays.toString()
 * Arrays.copyOf()
 * Arrays.binarySearch()
 * Arrays.fill(arr,9)  数组的填充
 * Arrays.equals()    判断数组是否相同
 * Arrays.fill(arr,2,7,99)  数组的部分填充  [2,7)填充为99
 * Arrays.sort(arr)    将数组排序
 *        原理：排序之后，剖析源代码
 */

public class Test {
    public static int arrMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static int arrMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static double arrAver(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum/arr.length;
    }

    //*数组逆置
    /**
     *
     * @param arr
     */
    public static void arrNegative2(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int tmp = arr[0];
            for (int j = 1; j < arr.length-i; j++) {
                arr[j-1] = arr[j];
            }
            arr[arr.length-1-i] = tmp;
        }
    }
    public static void arrNegative1(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    //*奇数放在偶数的前面

    /**
     *
     * @param arr
     */
    public static void oddAfterEven(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while(i < j) {
            //找奇数   i指向的是偶数
            while(arr[i]%2 == 1) {
                i++;
            }
            //找偶数   j指向的是奇数
            while(arr[j]%2 == 0) {
                j--;
            }
            if(i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }


    //二分查找递归
    /*public static int binarySearch(int[] arr,int key,int left,int right) {
        int mid = left + (right-left)/2;
        if(left > right) {
            return -1;
        }
        else if(arr[mid] == key) {
            return mid;
        }
        else if(arr[mid] > key) {
            return binarySearch(arr,key,left,mid-1);
        }
        else {
            return binarySearch(arr,key,mid+1,right);
        }
    }
    */
    //二分查找循环写法
    public static int binarySearch(int[] arr,int key,int left,int right) {
        while(left <= right) {
            int mid = (left+right)>>>1;
            if(arr[mid] == key) {
                return mid;
            }
            else if(arr[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static int[] transForm(int[] arr1) {
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i] * 2;
        }
        return arr2;
    }
    public static String toString(int[] arr) {
        String str = "[";
        for (int i = 0; i <arr.length; i++) {
            str += arr[i];
            if(i <arr.length-1) {
            str += ", ";
            }
        }
        return str + "]";
    }
    //冒泡排序
    //*每一趟的次数
    //*是否有续
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean bool = true;
            for (int j = 0; j < arr.length-1-i; j++) {
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

    public static void main(String[] args) {
        int[] arr = {3,1,7,4,8,5,6,2};
        oddAfterEven(arr);
        System.out.println(Arrays.toString(arr));
        //int ret = binarySearch(arr,7,0,arr.length-1);
        //int ret = binarySearch(arr,7,0,arr.length);
        //bubbleSort(arr);
        //System.out.println(Arrays.toString(arr));
        //int[] array = {1,2,3,4,5};
        //double ret = arrAver(array);
        //System.out.println(ret);
        //oddEvenNum(array);
        //System.out.println(Arrays.toString(array));
        //int[] arr1 = {1,2,3,4,5};
        //int[] arr2 = transForm(arr1);
        //System.out.println(toString(arr1));
        //System.out.println(Arrays.toString(arr2));
    }
}
