package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//删除最外层的括号
public class num_1021 {
    static Stack stack = new Stack();
    static List<String> list = new ArrayList<>();

    //这个有问题  没办法判断()()()  还是 ((()))
    /*public static String removeOuterParentheses(String S) {
        String str = "";
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.size() >= 2) {
                    str = stack.pop() + str + S.charAt(i);
                    if (stack.size() == 1) {
                        list.add(str);
                        str = "";
                    }
                } else if (stack.size() == 1) {
                    stack.pop();
                }
            }
        }
        StringBuffer res = new StringBuffer();
        if (list.size() == 0) {
            return "";
        } else {
            for (int i = 0; i < list.size(); i++) {
                res.append(list.get(i));
            }
            return res.toString();
        }
    }*/


    //直接省略外层的括号就好了  双指针法——当左括号和右括号数量相等时做字符串切片
    public static String removeOuterParentheses2(String S) {
        int left = 1;
        int right = 0;
        StringBuffer res = new StringBuffer();
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            if (right == left) {
                i++;
                left = 1;
                right = 0;
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    /*用栈来找边界 起始位置和结束位置 不能存字符？*/
    public String removeOuterParentheses3(String S) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int start = 0;// 初始化原语的起始位置
        int end = 0;// 初始化原语的结束位置
        boolean flag = false;// 标志每个原语

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '(') {// 遇到左括号，入栈
                stack.push(ch);
                if (!flag) {// 遇到的第一个左括号，是原语的开始位置，记录下原语开始位置
                    start = i;
                    flag = true;
                }
            }

            if (ch == ')') {// 遇到右括号，出栈
                stack.pop();
                if (stack.isEmpty()) {// 当栈空的时候，找到了一个完整的原语
                    end = i;// 记录下结束位置
                    ans.append(S.substring(start + 1, end));// 去掉原语的最外层括号，并追加到答案中
                    flag = false;// 置标志为false，往后接着找下一个原语
                    start = end;// 往后找，再次初始化原语开始位置
                }
            }
        }
        return ans.toString();
    }

    // 只是把 原语的最外层 括号去掉
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<Character>();
        String resultStr = "";

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (!stack.isEmpty()) {
                    resultStr += '(';
                }
                stack.push('(');
            } else if (S.charAt(i) == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    resultStr += ')';
                }
            }
        }
        return resultStr;
    }


    public static void main(String[] args) {
        String s = removeOuterParentheses2("((()())(()()))");
        System.out.println(s);
    }

}
