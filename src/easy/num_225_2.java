package easy;

import java.util.LinkedList;
import java.util.Queue;

public class num_225_2 {

    private Queue dataQueue;

    /** Initialize your data structure here. */
    public num_225_2() {
        dataQueue =  new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        dataQueue.add(x);
        int size = dataQueue.size();
        while (size > 1){
            dataQueue.add(dataQueue.poll());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return (int)dataQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        return (int)dataQueue.peek();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return dataQueue.isEmpty();
    }

}
