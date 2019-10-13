import java.util.Scanner;


public class Test{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int num = scan.nextInt();
		int j = 2;
		for(j = 2; j < num; j++) {
			if(num%j == 0) {
				System.out.println("不是素数");
				break;
				
				
			}
		}
		if(j == num) {
			System.out.println("是素数");
		}
		
		
	
	}
	
	public static void printPrime(int num) {
		int i = 2;
		for(i = 2;i < num;i++){
			if(num%i == 0){
				break;
			}
		}
		if(i == num){
			System.out.println(num);
			}
	}
	public static void main1(String[] args){
		
		for(int num = 1;num <= 100; num++) {
			printPrime(num);
		}
		
		/*
		int a = 1;
		int b = 2;
		System.out.println(a/b);
		
		double a = 1.0;
		int b = 2;
		System.out.println(a/b);
		
		int a = 1;
		int b = 0;
		System.out.println(a/b);
		
		
		System.out.println(3%2);//结果是1
		System.out.println(-3%2);//结果是-1
		System.out.println(-3.0%2);//结果是-1.0
		
		int a = 10;
		int b = a++;
		int c = ++a;
		System.out.println(b);
		System.out.println(c);
		
		
		int a = 10;
		int b = 20;
		System.out.println(a == b);
		System.out.println(a != b);
		System.out.println(a < b);
		System.out.println(a > b);
		System.out.println(a <= b);
		System.out.println(a >= b);
		
		int a = 10;
		int b = 20;
		int c = 30;
		//System.out.println(a > b && b < c);
		
		//System.out.println(a > b || b < c);
		System.out.println(!(a > b));
		
		System.out.println(10 > 20 & 10 / 0 == 0);// 出现异常
		System.out.println(10 < 20 | 10 / 0 == 0);// 出现异常
		
		int a = 10;//01010(省略高位27个0)
		int b = 20;//10100(省略高位27个0)
		//System.out.println(a & b);//结果是00000
		System.out.println(a | b);
		System.out.println(~a);
		
		
		
		
		int a = 1;//00000000 00000000 00000000 00000001
		int b = 2;//00000000 00000000 00000000 00000010
		System.out.println(a ^ b);//00000000 00000000 00000000 00000011
		
		
		int a = 10;//00000000 00000000 00000000 00001010
		a <<= 2;//   00000000 00000000 00000000 00101000
		System.out.println(a); //结果为40
		
		
		int a = -1;//补码：	11111111 11111111 11111111 11111111
		a >>= 2;//右移两位	11111111 11111111 11111111 11111111
		System.out.println(a);
		
		
		int a = 10;//	00000000 00000000 00000000 00001010
		a >>>= 2;//		00000000 00000000 00000000 00000010
		System.out.println(a);//结果为2
		
		
		int a = -10;//补码：	11111111 11111111 11111111 11110110
		a >>= 2;//右移两位	11111111 11111111 11111111 11111101
		System.out.println(a);//结果为-1
		
		
		// 求两个整数的大值 
		int a = 10; 
		int b = 20; 
		int max = a > b ? a : b;//表达式1为false，表达式3的值作为整个表达式的值
		System.out.println(max);
		*/
	}
}
