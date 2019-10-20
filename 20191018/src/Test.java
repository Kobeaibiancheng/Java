import java.util.Arrays;
import java.util.Scanner;

public class Test{
    public static void printNum(int n) {
        //n=5;00000000 00000000 00000000 00000101
        // 偶数位 0000000000000000
        // 奇数位 0000000000000011
        for (int i = 31; i >= 1 ; i -= 2) {
            System.out.print(((n >> i)&1) + " ");
        }
        System.out.println();
        for (int i = 30; i >= 0 ; i -= 2) {
            System.out.print(((n >> i)&1) + " ");
        }
    }

    public static int addSum(int[] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int ret = addSum(arr);
        System.out.println(ret);
        int[][] array1 = {{1,2,3},{4,5,6}};
        int[][] array2 = new int[][]{{1,2,3},{4,5,6}};
        int[][] array3 = new int[2][3];
        int[][] array4 = new int[2][];
        System.out.println(array1[0]);//运算结果：[I@1540e19d
        System.out.println(array2[1]);//运算结果：[I@677327b6
        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));*/
        //Scanner scan = new Scanner(System.in);
        //int num = scan.nextInt();
        //printNum(num);
    }
}
