package com;

public class TestDemo10 {
    public static int balancedStringSplit(String str) {
        int count = 0;
        int tmp = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                tmp++;
            }
            else {
                tmp--;
            }
            if (tmp == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str = "RLLLLRRRLR";
        int ret = balancedStringSplit(str);
        System.out.println(ret);
    }
}

