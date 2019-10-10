package easy;

import java.util.Stack;

public class num_155 {
    private static Stack dataStack ;
    private static Stack minHelpStack ;

    public num_155() {
        dataStack = new Stack();
        minHelpStack = new Stack();
    }

    static int minValue = Integer.MAX_VALUE;

    public static void push(int x) {
        if (dataStack.empty()){
            minValue = x;
        }else{
            minValue = Math.min(x, (Integer) minHelpStack.peek());
        }
        dataStack.push(x);
        minHelpStack.push(minValue);
    }

    public static void pop() {
        if (!dataStack.empty()){
            dataStack.pop();
            minHelpStack.pop();
        }
    }

    public static int top() {
        return (int) dataStack.peek();
    }

    public static int getMin() {
        if (!minHelpStack.empty()){
            return (int) minHelpStack.peek();
        }
        throw new RuntimeException("栈空");
    }

    public static void main(String[] args) {
        push(6);
        push(6);
        push(7);
        System.out.println(top());
        pop();
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        pop();
        push(7);
        System.out.println(top());
        System.out.println(getMin());
        push(8);
        System.out.println(top());
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
    }

}
