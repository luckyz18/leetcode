package easy;

import java.util.HashMap;
import java.util.Stack;

public class num_20 {
    public static boolean isValid(String s) {
        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c=='[' || c=='(' ){
                stack.push(c);
            }else {
                if (stack.isEmpty())
                    return false;
                char sta = (char) stack.pop();
                switch (c){
                    case '}':
                        if (sta != '{')
                            return false;
                        break;
                    case ']':
                        if (sta != '[')
                            return false;
                        break;
                    case ')':
                        if (sta != '(')
                            return false;
                        break;
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    //2.
    private HashMap<Character, Character> mappings;
    public num_20() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] args) {
        boolean f = isValid(")))}");
        System.out.println(f);
    }
}
