/**
辗转相除法：假设a大于b, a%b如果等于0,那么b就是a的最大公约数，如果不等于0
            那么将b赋值给a，（a%b）赋值给b。
                     （新的a）          （新的b）
			重复上述，直到a%b等于0，b为a的最大公约数 

*/
public class Test {
	//求两个正整数的最大公约数    ---    辗转相除法
	public static int maxCommonDivisor(int a,int b) {
		int result = 0;
		
			while(b != 0) {
				result = a % b;
				a = b;
				b = result;
			}
	
		
		return a;
		
	}
	public static void main(String[] args) {
		int a = 24;
		int b = 18;
		int ret = maxCommonDivisor(a,b);
		System.out.println(ret);
	}
	
	
	
	//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
	public static double numAdd() {
		double num = 0;
		int flag = 1;
		for(double i = 1.0;i <= 100;i++) {
			num += 1/(flag*i);
			flag = -flag;
		}
		return num;
	}
	public static void main3(String[] args) {
		double ret = numAdd();
		System.out.println(ret);	
	}
	
	
	
	
	//输出乘法口诀表
	public static void printTable() {
		for(int i = 1;i <= 9;i++) {
			for(int j = 1;j <= i;j++) {
				System.out.print(i + " * " + j + " = " + i*j +" ");
			}
			System.out.println();
		}
		
	}
	public static void main2(String[] args) {
		printTable();
	}
	
	
	
	//输出 1000 - 2000 之间所有的闰年
	public static void isLeapYear(int year) {
		if((year%4 == 0&&year%100 !=0)||year%400 == 0) {
			System.out.println(year);
		}
	}
	public static void main1(String[] args) {
		for(int year = 1000;year <= 2000;year++) {
			isLeapYear(year);
		}
	}
	
	
}