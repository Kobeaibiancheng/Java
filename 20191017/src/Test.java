import java.util.Scanner;

public class Test {
    public static void printAge(int age) {
        //根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        if(age <= 18) {
            System.out.println("少年");
        }
        else if(age >= 19 && age <= 28) {
            System.out.println("青年");
        }
        else if(age >= 29 && age<=55) {
            System.out.println("中年");
        }
        else {
            System.out.println("老年");
        }
    }
    public static int mathNum(int num1,int num2) {
        int tmp = 0;
        while(num1%num2 != 0) {
            tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return num2;
    }

    public static int numNine(int num) {
        int count = 0;
        for (int i = 1; i <= num ; i++) {
            if(i%10 == 9) {
                count++;
            }
            if(i/10 == 9) {
                count++;
            }
        }
        return count;
    }

    public static int avg(int a,int b) {        //((a&b)<<1 + a^b) 位运算求两个数和
        return (a&b) + (a^b)>>>1;                //(a&b) + (a^b)>>>1 平均数
    }

    public static void waterFlowers(int n) {
        for (int i = 0; i <= n ; i++) {
            int tmp = i;
            int count = 0;
            int sum = 0;
            //求一个数的位数
            while(tmp != 0) {
                tmp /= 10;
                count++;
            }
            tmp = i;
            //一个数的每一位的次方和
            while(tmp !=0) {
                sum += Math.pow(tmp%10,count);
                tmp /= 10;
            }
            if(i == sum) {
                System.out.println(i);
            }
        }
    }
    //水仙花数
    //Math.pow( , ,);

    public static void main(String[] args) {
        //System.out.println("Hello");//sout
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        waterFlowers(n);
        //int age = scan.nextInt();
        //printAge(age);
        //int ret = mathNum(24,18);
        //int ret = numNine(100);
        //System.out.println(ret);
    }
}
