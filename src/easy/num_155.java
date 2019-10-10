package easy;

import java.util.Stack;

public class num_155 {
    private static Stack dataStack = new Stack();
    private static Stack minHelpStack = new Stack();

    public num_155() {
        /*dataStack = new Stack();
        minHelpStack = new Stack();*/
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
        dataStack.pop();
        minHelpStack.pop();
    }

    public static int top() {
        return (int) dataStack.peek();
    }

    public static int getMin() {
        return (int) minHelpStack.peek();
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
