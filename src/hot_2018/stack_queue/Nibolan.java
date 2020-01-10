package hot_2018.stack_queue;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Nibolan {
    private static Stack<Integer> stack = new Stack<>();

    public static int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (int i = 0; i < tokens.length; i++) {
            if (set.contains(tokens[i])) {
                //符号
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                if (tokens[i].equals("+")) {
                    stack.push(num1 + num2);
                } else if (tokens[i].equals("-")) {
                    stack.push(num1 - num2);
                } else if (tokens[i].equals("*")) {
                    stack.push(num1 * num2);
                } else if (tokens[i].equals("/")) {
                    stack.push(num1 / num2);
                }
            } else {
                //数字
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        int i = evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(i);
    }
}
