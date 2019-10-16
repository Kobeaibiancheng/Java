/**
	猜数字游戏

*/
import java.util.Scanner;
import java.util.Random;
public class GuessNum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请猜数字->");
		Random rand = new Random();
		int randNum = rand.nextInt(100) + 1;
		while(true) {
			int num = scan.nextInt();
			if(num == randNum) {
				System.out.println("猜对了");
				break;
			}
			else if(num > randNum) {
				System.out.println("猜大了");
			}
			else {
				System.out.println("猜小了");
			}
		}
	}
}