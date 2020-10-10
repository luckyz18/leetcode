package easy;

import java.util.Stack;

/**
 * 反转链表
 */
public class num_206 {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int x) {
            value = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode p = head;
        while (p!= null){
            stack.push(p);
            p=p.next;
        }
        ListNode h = null;
        //head = h;
        while (!stack.isEmpty()){
            ListNode tmp = stack.pop();
            tmp.next = null;
            if (h == null){
                h = tmp;
                head = h;
            }else{
                h.next = tmp;
                h=h.next;
            }
        }
        return head;
    }

    //指针的方向反过来
    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }




    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        reverseList2(head);
    }
}
