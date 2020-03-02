package string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
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

    /**
     * 验证回文串
     * 只考虑字母和数字字符，可以忽略大小写
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }


    /**
     * 字符串转整数
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        //判断空格
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        //判断正负
        int flg = 1;
        int i = 0;
        if(str.charAt(i) == '-') {
            flg = -1;
            i++;
        }else if(str.charAt(i) == '+') {
            i++;
        }

        //得到数字
        int ret = 0;
        for(; i < str.length(); i++) {
            //处理其他非数字
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                return ret*flg;
            }
            //处理极限值
            if(flg == 1 && ret > Integer.MAX_VALUE/10 ||
                    (flg == 1 && ret == Integer.MAX_VALUE/10 && str.charAt(i) > '7')) {
                return Integer.MAX_VALUE;
            }
            if(flg == -1 && ret > Integer.MAX_VALUE/10 ||
                    (flg == -1 && ret == Integer.MAX_VALUE/10 && str.charAt(i) > '7')) {
                return Integer.MIN_VALUE;
            } else {
                ret = ret*10 + str.charAt(i) - '0';
            }
        }
        return ret * flg;
    }

    //宝石和石头
    public static int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < J.length();i++) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for(int i = 0;i < S.length();i++) {
            if(set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    //坏掉的键盘（牛客网）    Set集合
    public static void broken() {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();//预期输入的
        String str2 = scan.nextLine();//实际输入的
        Set<Character> set = new HashSet<>();
        //将实际输入的字符放入集合Set中
        for(char ch : str2.toUpperCase().toCharArray()) {
            set.add(ch);
        }


        Set<Character> broken = new HashSet<>();
        //遍历预期输入的字符串，如何set不包含，就代表是坏掉的键盘
        for(char ch : str1.toUpperCase().toCharArray()) {
            if(!set.contains(ch) && !broken.contains(ch)) {
                broken.add(ch);
                System.out.print(ch);
            }
        }
    }

    public static void fun() {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (scanner.hasNext()) {
            String str = scanner.next();
            set.add(str);
        }
        System.out.println(set.size());
    }



    private static boolean isPalindrome(StringBuffer str1) {
        StringBuffer stringBuffer = new StringBuffer(str1);

        if (stringBuffer.toString().equals(str1.reverse().toString())){
            return true;
        }
        return false;

    }

    /**
     * 统计回文
     * @return
     */
    public static int statisticalPalindromes() {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String str2 = scanner.nextLine();
        int count = 0;
        for(int i = 0; i <= str.length(); i++) {
            StringBuffer str1 = new StringBuffer(str);
            if(isPalindrome(str1.insert(i,str2))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        /*//String str1 = new String("hello");
        String str2 = new String("hello");
        String str1 = "hello";
        //String str2 = "hello";
        System.out.println(str1 == str2);*/
        //fun();
        /*System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(addBinary("1010","1011"));
        String str = "7_28]";
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