public class Test {
    public static void main(String[] args) {
        List lis = new List();
        lis.addPos(0,10);
        lis.addPos(1,20);
        lis.addPos(2,30);
        lis.addPos(0,0);
        System.out.println(lis.search(10));
        System.out.println(lis.getPos(6));
        lis.setPos(1,30);
        lis.printList();
        lis.remove(40);
        lis.printList();
        System.out.println(lis.listLength());
        lis.clearList();
    }
}
