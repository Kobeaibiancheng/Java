package collectionsframework;

public class TestDemo2 {
    public static void main(String[] args) {
        //int -> Integer 自动装包/装箱
        Integer a = 10;
        System.out.println(a);
        //int -> Integer 手动装包/装箱
        Integer b = Integer.valueOf(20);

        int c = a;//自动拆包/拆箱     默认拆成整型：intValue
        double d = a.doubleValue();//手动拆包/拆箱       拆成double：doubleValue
        System.out.println(c);
        System.out.println(d);
    }
}
