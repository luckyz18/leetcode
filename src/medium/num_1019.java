package medium;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num_1019 {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int x) {
            value = x;
        }
    }

    public static int[] nextLargerNodes(ListNode head) {
        int len = 0;
        int index = 0;
        ListNode t = head;
        while (t != null) {
            len += 1;
            t = t.next;
        }
        int[] res = new int[len];
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            while (q != null && q.value <= p.value) {
                q = q.next;
            }
            if (q == null) {
                res[index] = 0;
            } else {
                res[index] = q.value;
            }
            index++;
            p = p.next;
        }
        return res;
    }

    //单调栈实现
    public  static int[] nextLargerNodes2(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode p = head;
        int size = findSize(head);
        int[] res = new int[size];
        List<Integer> list = new ArrayList();

        while (p != null) {
            list.add(p.value);
            p = p.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= list.get(i)) {
                stack.pop();  //矮个起开
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(list.get(i));  //进去接受命运的审判吧
        }
        return res;

    }

    public static int findSize(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        nextLargerNodes2(head);
    }
}


class Info {
    public int ind;
    public int val;

    public Info(int ind, int val) {
        this.ind = ind;
        this.val = val;
    }
}

//单调栈解法 下一个更大元素师模板
class Solution {
    private int findSize(num_1019.ListNode head) {
        int size = 0;
        num_1019.ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public int[] nextLargerNodes(num_1019.ListNode head) {

        Stack<Info> stack = new Stack<Info>();
        int len = this.findSize(head);
        int[] result = new int[len];

        int index = 0;
        for (num_1019.ListNode temp = head; temp != null; temp = temp.next) {
            while (!stack.isEmpty() && stack.peek().val < temp.value) {
                result[stack.peek().ind] = temp.value;
                stack.pop();
            }

            stack.push(new Info(index, temp.value));
            index++;
        }

        return result;
    }
}

