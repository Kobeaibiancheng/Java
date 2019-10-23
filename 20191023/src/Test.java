import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //Arrays.copyOf();
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        double[] arr2 = {1.0,2.0,3.0,4.0,5.0,6.0,6.6};
        boolean[] arr3 = {true,false};
        char[] arr4 = {'h','e','l','l','o'};
        long[] arr5 = {1000,2000,3000};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
      /*[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        [1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 6.6]
        [true, false]
        [h, e, l, l, o]
        [1000, 2000, 3000]*/
    }
}
