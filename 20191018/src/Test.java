import java.util.Scanner;

public class Test{
    public static void printNum(int n) {
        //n=5;00000000 00000000 00000000 00000101
        // 偶数位 0000000000000000
        // 奇数位 0000000000000011
        for (int i = 31; i >= 1 ; i -= 2) {
            System.out.print(((n >> i)&1) + " ");
        }
        System.out.println();
        for (int i = 30; i >= 0 ; i -= 2) {
            System.out.print(((n >> i)&1) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        printNum(num);
    }
}
