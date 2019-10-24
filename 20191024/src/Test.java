import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.equals(arr1,arr2));
        /*
        int[] arr1 = {2, 5, 1, 4, 3, 9, 6, 7, 8, 10};
        int ret = Arrays.binarySearch(arr1,9);
        System.out.println(ret);
        Arrays.sort(arr1, 2, 8);
        System.out.println(Arrays.toString(arr1));
        int[] arr3 = null;
        int[] arr2 = Arrays.copyOf(arr3,10);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        for (int x:arr2) {
            System.out.print(x + " ");
        }
        System.out.println();
        int[] arr = new int[10];
        Arrays.fill(arr,99);
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,0,4,66);
        System.out.println(Arrays.toString(arr));*/
    }
}
