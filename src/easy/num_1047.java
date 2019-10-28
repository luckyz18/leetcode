package easy;

import java.util.HashSet;
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
                if (stack.peek() == c) {
                    flag = true;
                    continue;
                }
                if (flag) {
                    stack.pop();
                    i--;
                    flag = false;
                } else {
                    stack.push(c);
                }
            }
        }
        if (flag) {
            stack.pop();
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    // 1. 只删除 “两个” 相邻的
    public static String removeDuplicates2(String S) {
        Stack<Character> stack = new Stack<>();

        for (char s : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(s);
            } else if (stack.peek() == s) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }

        char[] result = new char[stack.size()];
        int i = result.length - 1;

        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }

        String res = new String(result);
        return res;
    }

    // 2. 因为只包含小写字母 所以用一个集合
    public String removeDuplicates3(String S) {
        // generate 26 possible duplicates
        HashSet<String> duplicates = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i <= 'z'; ++i) {
            sb.setLength(0);
            sb.append(i);
            sb.append(i);
            duplicates.add(sb.toString());
        }

        int prevLength = -1;
        while (prevLength != S.length()) {   //直到长度不变的时候
            prevLength = S.length();
            for (String d : duplicates) {
                S = S.replace(d, "");
            }
        }

        return S;
    }


    public static void main(String[] args) {
        String s = removeDuplicates2("abbac");
        System.out.println(s);

    }

}

//3.
// 用栈的“思想”
class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char c : S.toCharArray()) {
            if (sbLength != 0 && c == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(c);
                sbLength++;
            }
        }
        return sb.toString();
    }
}
