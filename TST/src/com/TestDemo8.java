package com;
import java.lang.Exception;

class MyException extends Exception {
    private String str;
    public MyException (String str) {
        super();
        this.str = str;
    }
    public void printStr() {
        System.out.println(this.str);
    }
}

class ArrayTools{
    //对给定的数组通过给定的角标获取元素。
    public static int getElement(int[] arr,int index)	{
        int element = arr[index];
        return element;
    }
}

public class TestDemo8 {
    public static void show () {
        int[] arr = null;
        try{
            if (arr == null) {
                throw new NullPointerException();
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("数组为null");
        }
        finally{
            ;
        }
    }
    public static void main2(String[] args) 	{
        show();
        int[] arr = {34,12,67};
        //int num = ArrayTools.getElement(arr,4);//静态方法用类名调用，不依赖于对象
        //System.out.println("num="+num);
        //System.out.println("程序结束");
    }



    public static void main4(String[] args) {
        int array[] = new int[1024*1024*1024];
        int a = 8/0;
        System.out.println(a);
        String str = null;
        System.out.println(str.length());
        int[] arr = {1,2,3};
        System.out.println(arr[3]);
        //该句运行时会发生数组越界异常ArraylndexOutOfBoundException
        //由于没有处理异常，导致程序无法继续进行，无法打印程序结束
        System.out.println("程序结束");
    }



    public static void main3(String[] args) {
        int a = 10;
        try{
            if(a == 10) {
                throw new MyException("wyx");
            }
        }catch (MyException e) {
            e.printStackTrace();
            System.out.println("异常");

        }
    }

    public static void main(String[] args) {
        Person per = null;
        try{
            per.study();
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("null异常");
        }finally{
            System.out.println("最后执行");
        }
    }
    public static void main1(String[] args) {
        int a = 10;
        try{
            if(a == 10) {
                throw new Exception("abc");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("最后执行");
        }
    }
}
