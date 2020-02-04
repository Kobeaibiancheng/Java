package string;

import java.util.Stack;

public class TestDemo1 {

    /**
     * 二进制求和
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        int p1 = a.length()-1;
        int p2 = b.length()-1;
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int sum = carry;
            sum += (p1 >= 0 ? a.charAt(p1--) - '0' : 0);
            sum += (p2 >= 0 ? b.charAt(p2--) - '0' : 0);
            stringBuffer.append(sum%2);
            carry = sum / 2;
        }
        stringBuffer.append(carry == 1 ? carry : "");
        return stringBuffer.reverse().toString();
    }

    /**
     * 反转字母
     * 字符串先转化为数组，new一个StringBuffer
     * 第一次遍历数组，将所有的字母入栈
     * 第二次遍历数组如果是字母栈顶元素就出栈(所以出栈就等价于对字母反序操作)
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (isLetter(c)) {
                stack.push(c);
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (char c : S.toCharArray()) {
            if (isLetter(c)) {
                stringBuffer.append(stack.pop());
            }else {
                stringBuffer.append(c);
            }
        }

        return  stringBuffer.toString();
    }

    //判断字符是否是字母字符
    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
    /**
     * 仅仅反转字母
     * @param S
     * @return
     */
    /*public static String reverseOnlyLetters1(String S) {
        //"a-bC-dEf-ghIj"
        char[] arr = S.toCharArray();
        int p1 = 0;
        int p2 = S.length()-1;
        while (p1 <= p2) {
            if (isLetter(arr[p1]) && isLetter(arr[p2])) {
                char tmp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = tmp;
                p1++;
                p2--;
            }else {
                if (!isLetter(arr[p1])) {
                    p1++;
                }
                if (!isLetter(arr[p2])){
                    p2--;
                }
            }
        }
        return new String(arr);
    }*/
    /**
     * 长按键入
     * @param name
     * @param typed
     * @return
     */
    public static boolean isLongPressedName(String name, String typed) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < name.length() && p2 < typed.length()) {
            if (name.charAt(p1) == typed.charAt(p2)) {
                p1++;
                p2++;
            }else if (p2 > 0 && typed.charAt(p2) == typed.charAt(p2-1)) {
                p2++;
            }else {
                return false;
            }
        }
        return p1 == name.length();
    }
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

    /**
     * 字符串集合
     * @param str  "abcdefacb" -> "abcdef"
     * @return
     */
    public static String gatherString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (!sb.toString().contains(tmp + "")) {
                sb = sb.append(tmp);
            }
        }
        return sb.toString();
    }

/*    public static int compress(char[] chars) {
        char ch = chars[0];
        int count = 1;
        StringBuilder str = new StringBuilder();
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == ch) {
                count++;
            }else{
                if(count != 1) {
                    str.append(ch).append(count);
                    count = 1;
                    ch = chars[i];
                }
            }
        }
        str.append(ch).append(count);
        System.out.println(str);
        return str.toString().toCharArray().length;
    }*/



    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
        /*String str = "7_28]";
        System.out.println(reverseOnlyLetters(str));
        System.out.println(isLongPressedName("abc","aabcc"));
        char[] arr = {'a','b','b','b'};
        String str = "abcdefacb";
        System.out.println(gatherString(str));
        String str = "aabbcdddeeef";//2a2b1c3d3e1f
        System.out.println(compress(str));
        StringBuilder src = null;
         String str = "LLRRLRLR";
        System.out.println(balancedStringSplit(str));*/
    }
}