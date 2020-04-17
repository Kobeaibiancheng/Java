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

    //链表 A + B    同字符串相加
    public static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        int carry = 0;
        while(a != null || b != null || carry != 0) {
            int aVal = a != null ? a.val : 0;
            int bVal = b != null ? b.val : 0;
            int sum = aVal + bVal + carry;
            int nodeVal = sum%10;
            carry = sum/10;
            cur.next = new ListNode(nodeVal);
            cur = cur.next;
            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
        }
        return newHead.next;
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


    private static Map<String, Integer> schemaToPort = new HashMap<>();
    static {
        schemaToPort.put("jdbc:mysql", 3306);
        schemaToPort.put("https", 443);
        schemaToPort.put("http", 80);
    }
    //"jdbc:mysql://127.0.0.1:3306/dbname?characterEncoding=utf8";
    public static void parser(String url) {
        String remain;
        String schema;
        {
            int i = url.indexOf("://");
            schema = url.substring(0, i);
            System.out.println("协议: " + schema);
            remain = url.substring(i + 3); // 跳过 :// 这 3 个字符
        }

        {
            // 确定有没有认证信息（用户名和密码）
            int i = remain.indexOf("@");
            if (i == -1) {
                System.out.println("用户名: ");
                System.out.println("密码: ");
            } else {
                String authentication = remain.substring(0, i);
                int j = authentication.indexOf(":");
                if (j == -1) {
                    System.out.println("用户名: " + authentication);
                    System.out.println("密码: ");
                } else {
                    String user = authentication.substring(0, j);
                    String password = authentication.substring(j + 1);
                    System.out.println("用户名: " + user);
                    System.out.println("密码: " + password);
                }
                // 切割认证信息
                // 再根据 : 分割 用户名和密码部分
                // remain = remain.substring()
                remain = remain.substring(i + 1);   // 1 跳过 @
            }
        }

        {
            // 确定主机 + 端口部分
            // 通过找 / 分割(主机 + 端口） 和 后边的部分
            int i = remain.indexOf("/");
            String ipAndPort = remain.substring(0, i);
            remain = remain.substring(i);   // 不要跳过 /

            // 根据 : 分割 主机 和 端口部分
            // 端口有可能没有写出来

            int j = ipAndPort.indexOf(":");
            if (j == -1) {
                String host = ipAndPort;
                int port = schemaToPort.get(schema);
                System.out.println("主机: " + host);
                System.out.println("端口: " + port);
            } else {
                String host = ipAndPort.substring(0, j);
                int port = Integer.parseInt(ipAndPort.substring(j + 1));
                System.out.println("主机: " + host);
                System.out.println("端口: " + port);
            }
        }

        {
            // 通过 ? 分割路径部分
            int i = remain.indexOf("?");
            if (i == -1) {
                int j = remain.indexOf("#");
                if (j == -1) {
                    String path = remain;
                    remain = "";
                    System.out.println("路径: " + path);
                } else {
                    String path = remain.substring(0, j);
                    remain = remain.substring(j);
                    System.out.println("路径: " + path);
                }
            } else {
                String path = remain.substring(0, i);
                remain = remain.substring(i + 1);

                System.out.println("路径: " + path);
            }
        }

        {
            // 通过 # 分割 query string 部分
            int i = remain.indexOf("#");
            if (i == -1) {
                String queryString = remain;
                remain = "";
                System.out.println("查询字符串: " + queryString);
            } else {
                String queryString = remain.substring(0, i);
                remain = remain.substring(i + 1);
                System.out.println("查询字符串: " + queryString);
            }
        }

        {
            // segment 部分
            System.out.println("片段标识符: " + remain);
        }
    }

    //整数与IP地址间的转换
    public static void ipChangeInt() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            if (str.contains(".")){
                String[] strs = str.split("\\.");
                //需要用long 类型来接收
                long ip = 0;
                long a1 = Long.valueOf(strs[0]) << 24;
                long a2 = Long.valueOf(strs[1]) << 16;
                long a3 = Long.valueOf(strs[2]) << 8;
                long a4 = Long.valueOf(strs[3]);
                ip = a1+a2+a3+a4;
                System.out.println(ip);
            }else {
                long num = Long.valueOf(str);
                long b1 = num >> 24;
                long b2 = num >> 16 & (0x00ff);
                long b3 = num >> 8 & (0x0000ff);
                long b4 = num &(0x000000ff);
                System.out.println(b1 + "." + b2 + "." + b3 + "." + b4);
            }
        }
    }


    //牛客：找x
    public static void searchX() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int x = sc.nextInt();
            for(int i = 0; i < n; i++) {
                if(x == arr[i]){
                    System.out.println(i);
                    return;
                }
            }
            System.out.println(-1);
        }
    }


    //牛客：守形数
    //      2 <= n <= 100
    public static void numberOfKeepShape() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            int squNum = num*num;
            while(num > 0) {
                if(num % 10 != squNum %10) {
                    System.out.println("No!");
                    return;
                }
                num /= 10;
                squNum /= 10;
            }
            System.out.println("Yes!");
        }

        /*Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            int squNum = num*num;
            int i = 0;
            if(num >= 2 && num <= 9) {
                i = 10;
            }else{
                i = 100;
            }
            if((squNum - num)%i == 0) {
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }*/
    }

    /**
     * 牛客：说反话
     *  Hello World Here I Come
     *  Come I Here World Hello
     *  先整体反转  然后单个单词反转
     */
    public static void reverseStr() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String[] strings = sc.nextLine().split(" ");
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < strings.length; i++) {
                stack.push(strings[i]);
            }
            for (int i = 0; i < strings.length; i++) {
                if (i != strings.length-1) {
                    System.out.print(stack.pop() + " ");
                }else {
                    System.out.print(stack.pop());
                }
            }
        }
    }

    /**
     * 十六进制转换为十进制
     */
    public static void conChangeDec() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();
            int sum = 0;
            int binary = 1;
            for(int i = str.length()-1; i >= 2; i--) {
                char ch = str.charAt(i);
                if(ch >= 'A' && ch <= 'F') {
                    sum += (ch - 'A' + 10)*binary;
                }else {
                    sum += (ch - '0')*binary;
                }
                binary = binary*16;
            }
            System.out.println(sum);
        }
    }

    /**
     * 空格替换
     * @param iniString
     * @param length
     * @return
     */
    public static String replaceSpace(String iniString, int length) {
        // write code here
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < length; i++) {
            if(iniString.charAt(i) != ' ') {
                str.append(iniString.charAt(i));
            }else {
                str.append("%20");
            }
        }
        return str.toString();
    }

    /**
     * 验证回文串
     * 给定一个字符串，能否通过添加一个字母将其变为回文串
     */
    public static void addToPalindrome() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            int i = 0;
            int j = str.length()-1;
            int flag = 0;
            while(i <= j) {
                if(str.charAt(i) != str.charAt(j)) {
                    if(i+1 <= j && str.charAt(i+1) == str.charAt(j)) {
                        i++;
                        flag++;
                    }else if(j-1 >= i && str.charAt(i) == str.charAt(j-1)) {
                        j--;
                        flag++;
                    }else {
                        flag += 2;
                        break;
                    }
                }else {
                    i++;
                    j--;
                }
            }
            if(flag < 2) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    /**
     * 删除公共字符
     *
     * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
     * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
     */
    public static void delSameChar() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            char[] arr = sc.nextLine().toCharArray();
            Set<Character> set = new HashSet<>();
            char[] str = sc.nextLine().toCharArray();
            for(char ch : str) {
                set.add(ch);
            }
            List<Character> list = new ArrayList<>();
            for(char ch : arr) {
                if(!set.contains(ch)) {
                    list.add(ch);
                }
            }
            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    /**
     * 句子逆序
     *
     * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
     * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
     */
    public static void SentencesReverseOrder() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            Stack<String> stack = new Stack<>();
            String[] strs = sc.nextLine().split(" ");
            for(int i = 0; i < strs.length; i++) {
                stack.push(strs[i]);
            }
            while(stack.size() > 0) {
                System.out.print(stack.pop()+ " ");
            }
        }

        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            if (str.contains(".")){
                String[] strs = str.split("\\.");
                long ip = 0;
                long a1 = Long.parseLong(strs[0]) << 24;
                long a2 = Long.parseLong(strs[1]) << 16;
                long a3 = Long.parseLong(strs[2]) << 8;
                long a4 = Long.parseLong(strs[3]);
                ip = a1+a2+a3+a4;
                System.out.println(ip);
            }else {
                long num = Long.parseLong(str);
                long b1 = num >> 24;
                long b2 = num >> 16 & (0x00ff);
                long b3 = num >> 8 & (0x0000ff);
                long b4 = num &(0x000000ff);
                System.out.println(b1 + "." + b2 + "." + b3 + "." + b4);
            }
        }
        //statisticalSingleDigits("10101");
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
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}