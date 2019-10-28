package easy;

import java.util.Stack;

public class num_682 {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if ("+".equals(op)) {
                int top1 = stack.pop();
                int top2 = stack.peek();
                int sum = top1 + top2;
                stack.push(top1);
                stack.push(sum);

            } else if ("D".equals(op)) {
                stack.push(stack.peek() * 2);
            } else if ("C".equals(op)) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = new String[] {"5","2","C","D","+"};
        int i = calPoints(str);
        System.out.println(i);
    }

}


