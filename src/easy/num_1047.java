package easy;

import java.util.Stack;

public class num_1047 {

    // 有问题  这个是删除一串的 bbb 题意是只删除“两个”
    public static String removeDuplicates(String S) {
         Stack<Character> stack = new Stack();
        Boolean flag = false;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c){
                    flag = true;
                    continue;
                }
                if (flag){
                    stack.pop();
                    i--;
                    flag = false;
                }else{
                    stack.push(c);
                }
            }
        }
        if (flag){
            stack.pop();
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    // 只删除 “两个” 相邻的
    public static String removeDuplicates2(String S) {
        Stack<Character> stack= new Stack<>();

        for(char s: S.toCharArray())
        {
            if(stack.isEmpty())
                stack.push(s);
            else if(stack.peek() == s)
                stack.pop();
            else
                stack.push(s);
        }

        char[] result= new char[stack.size()];
        int i=result.length-1;

        while(!stack.isEmpty())
        {
            result[i--]=stack.pop();
        }

        String res= new String(result);
        return res;
    }

    public static void main(String[] args) {
        String s = removeDuplicates2("abbac");
        System.out.println(s);

    }

}
