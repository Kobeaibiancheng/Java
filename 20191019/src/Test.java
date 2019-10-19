import java.util.Scanner;

public class Test {
    //打印一个数的每一位
    public static void printTable(int n) {
        //1234
        if(n > 9) {
            printTable(n/10);
        }
        System.out.print(n%10 + " ");
    }
    //1+2+3+4+....+(n-1)+n
    public static int sumNum(int n) {
        if(n == 1) {
            return 1;
        }
        else {
            return n +sumNum(n-1);
        }
    }
    //1234    ->  1+2+3+4
    public static int sumEach(int n) {
        if(n <= 9) {
            return n;
        }
        return n%10 +sumEach(n/10);
    }
    //斐波那契数列递归法
    public static int fabonacio1(int n) {
        if(n == 1 || n ==2) {
            return 1;
        }
        else {
            return fabonacio1(n-1) +fabonacio1(n-2);
        }
    }
    //斐波那契数列非递归（优化）
    public static int fabonacio2(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        //printTable(num);
        int ret = fabonacio2(num);
        System.out.println(ret);
    }
}
