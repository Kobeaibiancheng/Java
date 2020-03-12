package collectionsframework;

public class TestDemo4 {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        testHeap.createHeap(arr);
        testHeap.show();
        testHeap.pushHeap(80);
        testHeap.show();
        testHeap.popHeap();
        testHeap.show();
        System.out.println("===========");
        testHeap.heapSort();
        testHeap.show();
    }


}
