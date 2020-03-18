package string;

import java.util.*;

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


    //寻找字符串中的最长数字串
    public static String searchLongOfString(String str){
        int max = 0;
        int count = 0;//计数器
        int end = 0;//数字的尾部
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count++;
                if (max < count) {
                    max = count;
                    end = i;
                }
            }else {
                count = 0;
            }
        }
        return str.substring(end-max+1,end+1);
    }


    //合法括号序列判断
    public static boolean chkParenthesis(String str,int n) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }else if (str.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }else{
                    stack.pop();
                }
            }else {
                return false;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * 生成格雷码
     * @param n
     * @return
     */
    public static String[] getGray(int n) {
        // write code here
        String[] reStr = null;
        if (n == 1) {
            reStr = new String[]{"0","1"};
        }else {
            String[] strs = getGray(n-1);
            reStr = new String[2*strs.length];
            for (int i = 0; i < strs.length; i++) {
                reStr[i] = "0"+strs[i];
                reStr[reStr.length-1-i] = "1"+strs[i];
            }
        }
        return reStr;

    }

    /**
     * 牛客：超长整数相加（字符串相加）
     * @param addend
     * @param augend
     * @return
     */
    public static String AddLongInteger(String addend,String augend){
        int p1 = addend.length()-1;
        int p2 = augend.length()-1;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while (p1 >= 0 || p2 >= 0) {
            int n1 = p1 >= 0 ? addend.charAt(p1) - '0' : 0;
            int n2 = p2 >= 0 ? augend.charAt(p2) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            sb.append(tmp % 10);
            p1--;
            p2--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }


    // 牛客：个位数统计
    public static void statisticalSingleDigits(String str) {
        char[] arr = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        /*
               list有10个item表示0-9，每个item的值表示数字的个数
         */
        for (int i = 0; i < 10; i++) {
            list.add(0);//初始化 每一个item都是0
        }
        for (int i = 0; i < arr.length; i++) {
            //每遇到一个数字 就把值+1
            list.set(arr[i] - '0',list.get(arr[i] - '0')+1);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                System.out.println(i + ":" + list.get(i));
            }
        }
    }

    /**
     * 牛客：机器人走方格
     */
    public static int countWays(int x,int y){
        if (x == 1 || y ==1) {
            return 1;
        }
        return countWays(x-1,y)+countWays(x,y-1);
    }


    public static void main(String[] args) {
        statisticalSingleDigits("10101");
        /*String str1 = "99999";
        String str2 = "1";
        System.out.println(AddLongInteger(str1,str2));
        //String str1 = new String("hello");
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