public class Test {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
/*        singleList.addFirst(5);
        singleList.addFirst(4);
        singleList.addFirst(3);
        singleList.addFirst(2);
        singleList.addFirst(1);
        singleList.display2(singleList.removeElements(4));

        singleList.createLoop();
        System.out.println(singleList.hasCycle());
        System.out.println(singleList.detectCycle().data);*/
        singleList.addLast(2);
        singleList.addLast(5);
        singleList.addLast(4);
        singleList.addLast(3);
        singleList.addLast(6);
        singleList.addLast(1);
        singleList.display2(singleList.partition(5));

    }
}
