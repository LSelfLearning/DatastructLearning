package stack;

import common.Logger;

import java.util.Stack;

public class ParenthesisMatchingSolution {

    public static boolean isValid(String src) {
        Stack<Character> stack = new Stack<>();
        boolean isValid = false;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (c == ')' || c == ']' || c == '}') {
                    if (stack.isEmpty())
                        return false;
                    Character top = stack.pop();
                    if (c == ')' && top != '(')
                        return false;
                    if (c == ']' && top != '[')
                        return false;
                    if (c == '}' && top != '{')
                        return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Logger.logln(isValid("[哈哈{11(2233)444}555]"));
    }
}
