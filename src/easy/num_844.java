package easy;

import java.util.Stack;

public class num_844 {
    static Stack stack;

    public static boolean backspaceCompare(String S, String T) {
        stack = new Stack();
        String res1 = fun(S);
        String res2 = fun(T);
        if (res1.equals(res2)){
            return true;
        }else{
            return false;
        }
    }

    public static String fun(String S) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                 stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        boolean b = backspaceCompare("ab#c", "ad#c");
        System.out.println(b);
    }
}
