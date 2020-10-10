package medium;

import java.util.Stack;
//字符串解码
public class num_430 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    /**
     * 栈
     * 中序遍历
     * 没过 还在找原因
     *
     * @param head
     * @return
     */
    public static Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Stack<Node> stack = new Stack();
        Node p = new Node(0, null, null, null);
        //Node q = p;

        stack.push(head);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop.next != null) {
                stack.push(pop.next);
            }
            if (pop.child != null) {
                stack.push(pop.child);
                pop.child = null;
            }
            p.next = pop;
            pop.prev = p;
            p = p.next;
        }
        //q.next.prev = null;  // !
        //return q.next;
        //用上边的一样
        head.prev = null;  //!
        return head;
    }

    //
    class Solution {
        public Node flatten(Node head) {
            recursion(head);
            return head;
        }

        private Node recursion(Node node) {
            Node cur = node, pre = cur;
            while (cur != null) {
                if (cur.child != null) {
                    Node lastOneOfChild = recursion(cur.child);
                    lastOneOfChild.next = cur.next;
                    if (cur.next != null) {
                        lastOneOfChild.next.prev = lastOneOfChild;
                    }
                    cur.next = cur.child;
                    cur.next.prev = cur;
                    cur.child = null;
                    cur = lastOneOfChild;
                }
                pre = cur;
                cur = cur.next;
            }
            return pre;
        }
    }

    //网上kande
    public static Node flatten3(Node head) {
        if (head == null || (head.next == null && head.child == null))
            return head;
        Node temp = head;
        while (temp != null) {
            if (temp.child != null) {
                Node tempNext = temp.next;
                temp.next = flatten3(temp.child);
                temp.child = null;
                temp.next.prev = temp;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = tempNext;
                if (tempNext != null)
                    tempNext.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }


    // 不对
    public static Node flatten2(Node head) {
        /*Node temp = head;
        Node next;
        Node child;
        while (temp != null) {
            if (temp.next == null) {
                return temp;
            }
            child = temp.child;
            if (child != null) {
                while (child != null) {
                    next = temp.next;
                    temp.next = child;
                    child.prev = temp;
                    Node childTail = flatten(child);
                    childTail.next = next;
                    next.prev = childTail;
                    temp = next;
                    break;
                }
            } else {
                temp = temp.next;
            }
        }
        System.out.println("______________");

        return head;  // 这一步执行不到   */
        return null;
    }

    public static void main(String[] args) {
        Node num1 = new Node(1, null, null, null);
        Node num2 = new Node(2, null, null, null);
        Node num3 = new Node(3, null, null, null);
        Node num4 = new Node(4, null, null, null);
        Node num5 = new Node(5, null, null, null);
        Node num6 = new Node(6, null, null, null);
        Node num7 = new Node(7, null, null, null);
        Node num8 = new Node(8, null, null, null);
        num1.next = num2;
        num2.prev = num1;
        num2.next = num3;
        num3.prev = num2;
        num2.child = num4;
        num4.next = num5;
        num5.prev = num4;
        num5.next = num6;
        num6.prev = num5;
        num5.child = num7;
        num7.next = num8;
        num8.prev = num7;

        flatten(num1);
    }
}
