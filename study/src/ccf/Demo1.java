package ccf;

import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point>{
    int x;
    int y;
    double distance;
    int sign;

    @Override
    public int compareTo(Point o) {
        return (int)this.distance - (int)o.distance;
    }

    public int getSign() {
        return sign;
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        Point[] arr = new Point[n];
        /*int[] qu = new int[3];
        for (int i = 0; i < qu.length; i++) {
            qu[i] = 1000001;
        }*/
        for (int i = 0; i < n; i++) {
            Point point = new Point();
            point.x = sc.nextInt();
            point.y = sc.nextInt();
            point.distance = (Math.pow(X-point.x,2) + Math.pow(Y-point.y,2));
            point.sign = i+1;
            arr[i] = point;
            /*double tmp = point.distance;
            if (tmp < qu[0]) {
                if ()
            }*/
        }
        Arrays.sort(arr);
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i].getSign());
        }
    }
}
