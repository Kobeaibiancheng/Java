package programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static programming.SortDemo.quickSort;

public class Demo {
    //合法括号
    public boolean isValid(String s) {
        Map<Character,Character> pairs = new HashMap<Character,Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        


        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //右括号 进行比较
            if (pairs.containsKey(ch)) {
                //如果栈顶不是左括号  直接返回false  不是合法括号
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                //左括号直接push 入栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
