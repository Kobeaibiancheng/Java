import java.util.Scanner;

public class Test {
	//编写代码模拟三次密码输入的场景。 
	//最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输入，
	//最多输入三次。三次均错，则提示退出程序
	public static void main(String[] args) {
		int count = 1;
		int i = 0;
		String str = "123456";
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入密码->");
		for(i = 0;i < 3;i++) {
			String s = scan.nextLine();
			if(s.equals(str)) {               //两个字符串比较    
				System.out.println("登陆成功！");
				break;
			}
			else {
				System.out.println("密码输入错误！");
			}
		}
		if(i == 3) {
				System.out.println("退出程序！");
			}
	}
	
	
	//写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
	public static int numOne(int num) {
		int count = 0;
		for(int i = 0;i < 32;i++) {
			if((num & 1) == 1) {
				count++;
			}
			num >>>= 1;
		}
		return count;
	}
	public static void main3(String[] args) {
		System.out.println(numOne(15));//00000000 00000000 00000000 000000101
		
	}
	
	//输出一个整数的每一位
	public static void printEach(int num) {
		if(num > 9) {
			printEach(num/10);
		}
		System.out.println(num%10);
	}
	public static void main2(String[] args) {
		int num = 1234;
		printEach(num);	
	}
	
	
	//1到 100 的所有整数中出现多少个数字9
	public static int numNine() {
		int count = 0;
		for(int i = 1;i <= 100;i++) {
			if(i / 10 == 9) {
				count++;
			}
			if(i % 10 == 9) {
				count++;
			}
		}
		return count;
	}
	public static void main1(String[] args) {
		System.out.println(numNine());
	}
}