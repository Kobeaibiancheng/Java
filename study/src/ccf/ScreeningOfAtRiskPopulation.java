package ccf;

import java.util.Scanner;
class ScreeningOfAtRiskPopulation {
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int numberPerson = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int xl = sc.nextInt();
        int yd = sc.nextInt();
        int xr = sc.nextInt();
        int yu = sc.nextInt();
        int been = 0;
        int stay = 0;
        for (int i = 0; i < numberPerson; i++) {
            int count = 0;
            int point = 0;
            for (int j = 0; j < t; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (point == 2) {
                    continue;
                }
                boolean flag = x >= xl && y >= yd && x <= xr && y <= yu;
                if (flag) {
                    count++;
                    point =1;
                }else {
                    count = 0;
                }
                if(count >= k){
                    count = 0;
                    point = 2;
                }
            }
            if (point == 2) {
                been++;
                stay++;
            }else if (point == 1) {
                been++;
            }
        }
        System.out.println(been);
        System.out.println(stay);
    }
}

