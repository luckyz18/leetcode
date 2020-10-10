package medium;

import java.util.LinkedList;
import java.util.Stack;
//字符串解码
public class num_394 {

    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else res.append(c);
        }
        return res.toString();
    }

    //第二种思路，就是从最里的【 到 最外的】 计算 逐渐向外扩
    public static String decodeString2(String s) {
        while (s.indexOf("[") != -1) {
            int left = s.lastIndexOf("[");
            //int right = s.indexOf("]");// 错
            int right = left + s.substring(left).indexOf("]");
            String word = s.substring(left + 1, right);
            String multi = "";
            while (left - 1 >= 0 && s.charAt(left - 1) >= '0' && s.charAt(left - 1) <= '9') {
                multi = s.charAt(left - 1) + multi;
                left--;
            }
            int count = Integer.parseInt(multi);
            StringBuffer tmp = new StringBuffer();
            for (int i = 0; i < count; i++) {
                tmp.append(word);
            }
            s = s.substring(0, left) + tmp + s.substring(right + 1);
        }
        return s;
    }

    //用一个栈解决
    class Solution {
        public String decodeString(String s) {
            Stack<String> stack = new Stack<>();
            String str = "";
            int i = 0;
            while (i < s.length()) {
                if (i < s.length() && Character.isDigit(s.charAt(i))) {
                    // since the integer can be of length > 1
                    String num = "";
                    while (Character.isDigit(s.charAt(i))) {
                        num += s.charAt(i);
                        i++;
                    }
                    stack.push(num);
                }
                if (i < s.length() && Character.isLetter(s.charAt(i))) {
                    // since a group of chars between [ ] can have more than 1 char
                    str = "";
                    while (i < s.length() && Character.isLetter(s.charAt(i))) {
                        str += s.charAt(i);
                        i++;
                    }
                    stack.push(str);
                }
                if (i < s.length() && s.charAt(i) == '[') {
                    // We need [ to define boundaries of a group
                    stack.push("[");
                    i++;
                }
                // Now we will 'reduce' the strings iteratively
                if (i < s.length() && s.charAt(i) == ']') {
                    str = stack.pop();
                    // Combine this string with any intermediate string lying on the stack
                    while (!stack.isEmpty() && !stack.peek().equals("[")) {
                        str = stack.pop() + str;
                    }
                    if (!stack.isEmpty() && stack.peek().equals("["))
                        stack.pop();

                    int num = Integer.parseInt(stack.pop());
                    str = repeatString(str, num);
                    stack.push(str);
                    i++;
                }
            }
            str = "";
            while (!stack.isEmpty()) {
                str = stack.pop() + str;
            }
            return str;
        }

        public String repeatString(String str, int num) {
            StringBuilder sb = new StringBuilder(str.length() * num);
            for (int i = 0; i < num; i++) {
                sb.append(str);
            }
            return sb.toString();
        }
    }

    //
    class Solution2 {
        public String decodeString(String s) {
            Stack<Integer> cntStack = new Stack<>();
            Stack<StringBuilder> strStack = new Stack<>();
            char[] chars = s.toCharArray();
            StringBuilder result = new StringBuilder();

            int currDigit = 0;
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    currDigit = currDigit * 10 + Character.getNumericValue(c);
                } else if (Character.isLetter(c)) {
                    if (strStack.isEmpty()) {
                        result.append(c);
                    } else {
                        strStack.peek().append(c);
                    }
                } else if (c == '[') {
                    cntStack.push(currDigit);
                    strStack.push(new StringBuilder());
                    currDigit = 0;
                } else if (c == ']') {
                    String currStr = getCurrStr(strStack.pop(), cntStack.pop());
                    if (strStack.isEmpty()) {
                        result.append(currStr);
                    } else {
                        strStack.peek().append(currStr);
                    }
                }
            }
            return result.toString();
        }
        private String getCurrStr(StringBuilder sb, int cnt) {
            String str = sb.toString();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < cnt; i++) {
                result.append(str);
            }

            return result.toString();
        }
    }


    public static void main(String[] args) {
        String s = decodeString2("3[a2[c]4[d]]");
        System.out.println(s);

    }


}


