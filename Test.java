

public class Test
{
	public static void main(String[] args)
	{
		/*char ch1 = '9';
		char ch2 = 'w';
		char ch3 = 300;
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println("hello java!");
		System.out.println("hello world!");
		int a = 10;
		int b = 20;
		String str1 = "hello";
		String str2 = "java";
		System.out.println(str1+str2);
		System.out.println("a = "+a);
		System.out.println(b + a);
		
		String str = "result = ";
		int a = 10;
		int b = 20;
		String result = str + a + b;
		System.out.println(result);
		
		int a = 10;
		int b = 20;
		System.out.println("a = " + a +",b = " + b);
		
		//final关键字修饰的常量
		final int a = 20;
		//编译出错，无法为最终变量a分配值
		a = 10;
		
		//理解类型的转换
		int a = 10;
		long b = 20;
		a = b;
		b = a;
		
	
		int a = 10;
		double b = 10.0;
		//a = b;
		b = a;
		
		int a = 10;
		boolean bool = true;
		a = bool;//编译出错，提示不兼容的类型，无法转换
		bool = a;//编译出错，提示不兼容的类型，无法转换
		
		
		byte a = 100;
		byte b = 256;//编译出错，提示从int转换为byte可能会有损失。超出了byte（一个字节）所能存放的最大的数（255）
		
		int a = 0;
		double b = 2.0;
		a = (int)b;
		
		
		int a = 10;
		double b = 5.0;
		b = (double)a;
		
		
		int a = 20;
		boolean bool = false;
		a = (boolean)false;//编译出错，提示不兼容的类型*/
		
		//强制类型转换会可能会导致数据的损失，如double b = 2.5转换为int小数点后面就会被忽略
		//强制类型转换不一定会成功，互不相干的类型之间无法强行转换
		
		
		//总计：1.不同数字类型的变量之间赋值, 表示范围更小的类型能隐式转换成范围较大的类型
		//      2.如果需要把范围大的类型赋值给范围小的, 需要强制类型转换, 但是可能精度丢失
		//      3.将一个字面值常量进行赋值的时候, Java 会自动针对数字范围进行检查
	}
}
