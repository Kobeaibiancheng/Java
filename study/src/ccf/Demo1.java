package ccf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class point{
    int x;
    int y;
    int 
}
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Double> map = new HashMap<>();
        int n = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = (X-x)*(X-x) + (Y-y)*(Y-y);
            map.put(i,arr[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print( + " ");
        }
    }
}
