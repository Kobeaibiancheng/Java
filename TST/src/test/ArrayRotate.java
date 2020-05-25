package test;

public class ArrayRotate {
    private int[][] arr;

    public ArrayRotate(int[][] arr,int n) {
        this.arr = arr;
    }

    void clockwiseRotate() {
        int[][] ret = new int[arr[0].length][arr.length];
        int dst = arr.length-1;
        for(int i = 0; i < arr.length; i++,dst--){
            for(int j = 0; j < arr[0].length; j++){
                ret[j][dst] = arr[i][j];
            }
        }
        arr = ret;
    }
    void show() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                System.out.format("%2d ",arr[i][j]);
            }
            System.out.println();
        }
    }

    void unclockwiseRotate() {
        int[][] ret = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ret[3-j][i] = arr[i][j];
            }
        }
        arr = ret;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayRotate test = new ArrayRotate(arr,4);
        //test.clockwiseRotate();
        test.unclockwiseRotate();
        test.show();
    }
}
