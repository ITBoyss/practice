package data_structure.stack.application;

import org.junit.Test;

import java.util.Stack;

/**
 * @ProjectName: algorithm
 * @Description: 栈应用 括号匹配 leetcode 20
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/18 9:26
 * @Version: 1.0.0
 */
public class App1 {

    @Test
    public void test1() {
        String s = "([{}])";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
