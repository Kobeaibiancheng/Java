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
        int n = sc.nextInt();
        int[] num = new int[5];
        L[] node = new L[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            L l = new L();
            l.x = x;
            l.y = y;
            node[i] = l;
        }
        for (int i = 0; i < n; i++) {
            //标志是否符合回收站 == 4 表示符合
            int count = 0;
            //回收站得分数
            int cut = 0;
            for (int j = 0; j < n; j++) {
                if (node[i].x + 1 == node[j].x && node[i].y == node[j].y) {
                    count++;
                }
                if (node[i].x - 1 == node[j].x && node[i].y == node[j].y) {
                    count++;
                }
                if (node[i].y + 1 == node[j].y && node[i].x == node[j].x) {
                    count++;
                }
                if (node[i].y - 1 == node[j].y && node[i].x == node[j].x) {
                    count++;
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
                switch (cut) {
                    case 0:
                        num[0] = 0;
                        break;
                    case 1:
                        num[1]++;
                        break;
                    case 2:
                        num[2]++;
                        break;
                    case 3:
                        num[3]++;
                        break;
                    case 4:
                        num[4]++;
                        break;
                }
            }
        }
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}
