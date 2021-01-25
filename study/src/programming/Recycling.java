package programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class L {
    int x;
    int y;
}
public class Recycling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        List<L> list = new ArrayList<>();

        int[] num = new int[5];
        int k = 0;
        L[] node = new L[n];


        for (int i = 0; i < n; i++) {
            String[] strings = sc.nextLine().split(" ");
            int x = Integer.valueOf(strings[0]);
            int y = Integer.valueOf(strings[1]);
            L l = new L();
            l.x = x;
            l.y = y;
            node[i] = l;
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            int cut = 0;
            for (int j = 0; j < n; j++) {
                if (node[i].x + 1 == node[j].x && node[i].y == node[j].y) {
                    count++;
                    //cut++;
                }
                if (node[i].x - 1 == node[j].x && node[i].y == node[j].y) {
                    count++;
                    //cut++;
                }
                if (node[i].y + 1 == node[j].y && node[i].x == node[j].x) {
                    count++;
                    //cut++;
                }
                if (node[i].y - 1 == node[j].y && node[i].x == node[j].x) {
                    count++;
                    //cut++;
                }
                if (node[i].x + 1 == node[j].x && node[i].y + 1 == node[j].y) {
                    cut++;
                }
                if (node[i].x + 1 == node[j].x && node[i].y - 1 == node[j].y) {
                    cut++;
                }
                if (node[i].x - 1 == node[j].x && node[i].y + 1 == node[j].y) {
                    cut++;
                }
                if (node[i].x - 1 == node[j].x && node[i].y - 1 == node[j].y) {
                    cut++;
                }
            }
            if (count == 4) {
                num[k] = cut;
                k++;
            }

        }
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}
