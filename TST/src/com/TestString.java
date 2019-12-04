package com;

public class TestString {
    public static boolean isAllNum(String str) {
        /*char[] arr = str.toCharArray();
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            if(arr[i] < '0' || arr[i] > '9') {
                return false;
            }
        }*/
        for (int j = 0; j < str.length(); j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = new String("abcdef");
        System.out.println(str1 == str2);//false
        String str = "1a23456";
        System.out.println(str.charAt(1));
        System.out.println(isAllNum(str));
/*      String str3 = "abc" + "def";
        System.out.println(str1 == str3);//true
        String str4 = "abc" + new String("def");
        System.out.println(str1 == str4);//false
 */
    }
}