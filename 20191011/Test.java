public class Test{
	public static void main(String[] args){
		int sum = 0;
		int ret = 1;
		for(int i = 1; i<=5; i++){
			ret *= i;
			sum += ret;
		}
		System.out.println("sum = " + sum);
		/*int sumOdd = 0;
		int sumEve = 0;
		for(int i = 1; i<=100; i++){
			if(i%2 == 0){
				sumEve += i;
			}
			else{
				sumOdd += i;
			}
		}
		System.out.println("sumEve = " + sumEve);
		System.out.println("sumOdd = " + sumOdd);
		*/
	}
}