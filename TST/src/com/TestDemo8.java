package com;

class MyExpection extends Exception {
    private String str;
    public MyExpection (String str) {
        super();
        this.str = str;
    }
    public void printStr() {
        System.out.println(this.str);
    }
}

public class TestDemo8 {
    public static void main(String[] args) {
        int a = 10;
        try{
            if(a == 10) {
                throw new MyExpection("wyx");
            }
        }catch (MyExpection e) {
            e.printStackTrace();
            System.out.println("异常");

        }
    }

    public static void main2(String[] args) {
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
