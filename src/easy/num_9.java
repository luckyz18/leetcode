package easy;

import java.util.Stack;

public class num_9 {
    public static  boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        Stack stack = new Stack();
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }
        for (int i = 0; i <chars.length ; i++) {
            if (stack.pop().equals(chars[i])){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(-122);
        System.out.println(palindrome);
    }
}
