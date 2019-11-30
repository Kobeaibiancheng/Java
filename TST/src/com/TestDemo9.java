package com;

import java.util.Arrays;

public class TestDemo9 {
    public static int[] mergeArr(int[] arr1, int[] arr2) {
        int[] ret = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i != arr1.length && j != arr2.length) {
            if (arr1[i] <= arr2[j]) {
                ret[k++] = arr1[i++];
               /* i++;
                k++;*/
            } else {
                ret[k++] = arr2[j++];
            /*    j++;
                k++;*/
            }

        }
        while (i < arr1.length) {
            ret[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            ret[k++] = arr2[j++];
        }
        return ret;
    }

    public static String func(String str) {
        char ch = str.charAt(0);
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            } else {
                stringBuilder.append(count).append(ch);
                ch = str.charAt(i);
                count = 1;
            }
        }
        return stringBuilder.append(count).append(ch).toString();
    }


    public static void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static String reverseSentence(String str) {
        char[] array = str.toCharArray();
        reverse(array, 0, array.length - 1);
        int i = 0;
        int j = 0;
        //单词逆置
        while (i < array.length) {
            if (array[i] == ' ') {
                i++;
                j++;
            } else if (j == array.length || array[j] == ' ') {
                reverse(array, i, j - 1);
                j++;
                i = j;
            } else {
                j++;
            }
        }
        return String.copyValueOf(array);
    }
    public static void main(String[] args) {
        String str = " i am a student";
        System.out.println(reverseSentence(str));
    /*  String str = "aabbccddaaa";
        System.out.println(func(str));
        int[] arr1 = {1,3,6,9};
        int[] arr2 = {2,4,6,8};
        int[] ret = mergeArr(arr1,arr2);
        System.out.println(Arrays.toString(ret));*/
    }
}

