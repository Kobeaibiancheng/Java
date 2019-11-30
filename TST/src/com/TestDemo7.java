package com;

import java.util.Scanner;
public class TestDemo7 {
    //无冗余地拼接两个字符串
    public static String func(String str) {
        String[] strings = str.split(" ");
        String ret = "";
        for (int i = 0; i < strings.length; i++) {
            ret += strings[i];
        }
        return ret;
    }

    //反转字符串
    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return new String(arr);
    }




    public static String reverse2(String str,int start,int end) {
        char[] arr = str.toCharArray();
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        return new String(arr);
    }
    //给一个字符类型的数组chas和一个整数size，请把大小为size的左半区整体右移到右半区，右半区整体移动到左边。
    public static String func(String str,int k) {
        if(str == null || k <= 0 || str.length() == 0) {
            return null;
        }
        String ret = reverse2(str,0,k-1);
        ret = reverse2(ret,k,ret.length()-1);
        ret = reverse2(ret,0,ret.length()-1);
        return ret;
    }


    public static void main(String[] args) {
        /*try {

        }catch () {

        }
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        String str = scan.next();
        String ret = func(str,k);
        System.out.println(ret);
        String str = "abcdef";
        System.out.println(reverse(str));
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        //无冗余地拼接两个字符串
        String ret = func(str);
        System.out.println(ret);*/
    }
}
