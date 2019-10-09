public class Test{
	public static void main(String[] args){
		int a = 10;
		int b = 20;
		System.out.println(a);
		System.out.println(b);
		int tmp = a;
		a = b;
		b = tmp;
		System.out.println(a);
		System.out.println(b);
	}
	public static void main1(String[] args){
		int a = 10;
		int b = 20;
		int c = 15;
		int tmp = 0;
		if(a > b){
			tmp = b;
			b = a;
			a = tmp;
		}
		if(a > c){
			tmp = c;
			c = a;
			a = tmp;
		}
		if(b > c){
			tmp = c;
			c = b;
			b = tmp;
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}