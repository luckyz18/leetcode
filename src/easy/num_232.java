package easy;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class num_232 {
    /** Initialize your data structure here. */
    private Stack stack;
    private Stack daoStack;
    public num_232() {
        stack = new Stack();
        daoStack = new Stack();
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
        //dao(stack);
    }
    private void dao(Stack stack){
        if (!stack.isEmpty() && daoStack.isEmpty()){
            while (!stack.isEmpty()){
                daoStack.push(stack.pop());
            }
        }
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        dao(stack);
        return (int) daoStack.pop();
    }
    /** Get the front element. */
    public int peek() {
        dao(stack);
        return (int) daoStack.peek();
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        dao(stack);
        return daoStack.isEmpty();
    }
}
