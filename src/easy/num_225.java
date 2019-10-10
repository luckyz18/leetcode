package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路1： 两个队列，dao到另一个辅助队列
 * 思路2： ；两个队列，q1 里边的假设已经是栈的顺序
 * 思路3： 一个队列  在原队列上进行反转
 */
public class num_225 {
    private Queue dataQueue;
    private Queue helpQueue;
    /** Initialize your data structure here. */
    num_225() {
        dataQueue =  new LinkedList();
        helpQueue =  new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        dataQueue.add(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (dataQueue.size() != 1){
            helpQueue.add(dataQueue.poll());
        }
        int tmp = (int) dataQueue.poll();
        Queue t = new LinkedList();
        t = dataQueue;
        dataQueue = helpQueue;
        helpQueue = t;
        return tmp;
    }

    /** Get the top element. */
    public int top() {
        while (dataQueue.size() != 1){
            helpQueue.add(dataQueue.poll());
        }
        int tmp = (int) dataQueue.poll();
        helpQueue.add(tmp);
        Queue t = new LinkedList();
        t = dataQueue;
        dataQueue = helpQueue;
        helpQueue = t;
        return tmp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return dataQueue.isEmpty();
    }


}
