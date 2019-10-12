public class Test{
	public static void swap(int[] arr){
		int tmp = arr[0];
		arr[0] = arr[1];
		arr[1] = tmp;
	}
	public static void main(String[] args){
		int[] arr = {10,20};
		System.out.println("arr[0] = " + arr[0]);
		System.out.println("arr[1] = " + arr[1]);
		swap(arr);
		System.out.println("arr[0] = " + arr[0]);
		System.out.println("arr[1] = " + arr[1]);
	}
}