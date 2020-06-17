package test;

import java.util.Scanner;

//编程题：餐馆
/*
思路：优先选消费额度大的客人安排就餐
对客人按照消费额度排序（大->小）
对桌子按照容量排序（大->小）
选取当前消费额度最大客人：
1.如果没有桌子可用，结束；
2.如果人数过多无法安排，跳过；
3.如果可安排，则找到最合适的桌位，可就餐的桌位中容量最小的；
  3.1向这批客人收费；
  3.2将桌子从可用资源中删除；
直到没有桌子可用或所有客人全部安排
*/
public class Greed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//总共n个桌子
            int m = sc.nextInt();

        }
    }
}
