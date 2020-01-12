package collectionsframework;

/**
 * MyArrayList:泛型类
 * <T>:T他只是一个占位符，标识当前类为泛型类
 * @param <T>
 * 泛型的意义是什么？
 *      1.可以进行自动类型检查
 *      2.自动进行类型转换
 * 泛型的陷阱：
 *      1.泛型类型的参数不能是简单类型。一定要是对象的包装类
 *      MyArrayList<int> myArrayList3 = new MyArrayList<>();  错误
 *      2.不能够new一个泛型类型的数组T[]        T[] elem = new T[10];
 *      3.泛型类型的参数不参与类型的组成
 * 面试问题：泛型是怎么编译的？
 *          ****擦除机制****：擦除为Object
 */
public class MyArrayList<T> {
    public T[] elems;
    public int usedSize;
    public MyArrayList() {
        //this.elems = new T[10];错误
        this.elems = (T[])new Object[10];
        this.usedSize = 0;
    }
    public void add(T data) {
        this.elems[this.usedSize] = data;
        this.usedSize++;
    }
    public T get() {
        return this.elems[this.usedSize-1];
    }
}
