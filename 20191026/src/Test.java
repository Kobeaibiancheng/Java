/**
 * 多画图，多写代码
 * 类和对象博客
 * 顺序表多写:早上写，中午写，晚上写，做梦也在写
 */
public class Test {
    public static void main(String[] args) {
        List list = new List();
        list.add(0,99);
        list.add(1,88);
        list.add(2,77);
        /*System.out.println(list.search(77));
        list.disPlay();
        System.out.println(list.getPos(1));
        list.disPlay();*/
        list.setPos(0,10);
        list.disPlay();
        list.remove(20);
        list.disPlay();
        System.out.println(list.listLength());
    }
}
