package hot100;

import java.util.Stack;

/**
 * 有效括号的长度
 */
public class Code_LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 初始化栈，用于计算有效括号的长度
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
//        String s1 = "(()"; // Output: 2
        String s2 = ")()(())"; // Output: 4
//        System.out.println("Longest valid parentheses for s1: " + longestValidParentheses(s1));
        System.out.println("Longest valid parentheses for s2: " + longestValidParentheses(s2));
    }
}
