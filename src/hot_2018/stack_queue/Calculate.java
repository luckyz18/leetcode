package hot_2018.stack_queue;

import java.util.Stack;

/**
 * 计算器
 */
public class Calculate {
    public static int calculate(String s) {
        int res = 0, d = 0;
        char sign = '+';
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                d = d * 10 + (c - '0');
            }
            if (!(Character.isDigit(c) || c==' ') || i == s.length() - 1) {  //! 考虑最后一位
                if (sign == '+') {
                    nums.push(d);
                } else if (sign == '-') {
                    nums.push(-d);
                } else if (sign == '*' || sign == '/') {
                    int tmp = sign == '*' ? nums.peek() * d : nums.peek() / d;
                    nums.pop();
                    nums.push(tmp);
                }
                sign = c; //保存当前符号
                d = 0;
            }
        }
        for(int i : nums){
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        int calculate = calculate("22 - 3*4");
        System.out.println(calculate);
    }
}
