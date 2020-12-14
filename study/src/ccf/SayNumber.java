package ccf;

import java.util.Scanner;

class SayNumber {
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[4];
        int i = 0;
        int num =1;
        while (n > 0) {
            if(jump(num)) {
                arr[i]++;
            }else {
                n--;
            }
            num++;
            i = (i+1)%4;
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }

    private static boolean jump(int num) {
        int i = num;
        //判断是不是7的倍数
        if (num%7 == 0) {
            return true;
        }else {
            //判断是否含有数字7
            while (i > 0) {
                num = i%10;
                if (num == 7) {
                    return true;
                }
                i /= 10;
            }
            return false;
        }
    }
}
