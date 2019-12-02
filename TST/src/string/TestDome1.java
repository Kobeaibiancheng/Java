package string;

import java.util.Arrays;

public class TestDome1 {
    //分割平衡字符串
    public static int balancedStringSplit(String str) {
        if(str == null || "".equals(str)) {
            return 0;
        }
        int count = 0;
        int diffCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                diffCount++;
            }else {
                diffCount--;
            }
            if (diffCount == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 反转字符串
     * @param str "abcdef" -> "fedcba"
     * @return
     */
    public static String reverseString(String str) {
        if (str == null) {
            return null;
        }
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(arr);
    }

    /**
     * 压缩字符串
     * @param str   "aabbcdddeeef" ->"2a2b1c3d3e1f"
     * @return
     */
    public static String compress(String str) {
        StringBuilder ret = new StringBuilder();
        char ch = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }else {
                ret.append(count).append(ch);
                ch = str.charAt(i);
                count = 1;
            }
        }
        return  ret.append(count).append(ch).toString();
    }

    /**
     * 旋转字符串
     * @param A "abcde"
     * @param B "cdeab"
     * @return
     */
   public static boolean rotateString(String A, String B) {
        return (A.length() == B.length()) && (A+A).contains(B);
    }

    public static void main(String[] args) {

        /*String str = "aabbcdddeeef";//2a2b1c3d3e1f
        System.out.println(compress(str));
        StringBuilder src = null;
         String str = "LLRRLRLR";
        System.out.println(balancedStringSplit(str));*/
    }
}
