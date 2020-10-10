package hard;


import java.util.Stack;

/**
 * K个一组翻转链表
 */
public class num_25 {
    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int data) {
            this.value = data;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        ListNode newHead = head;
        ListNode cur = head;
        ListNode tail = null;
        ListNode next;
        Stack<ListNode> stack = new Stack();
        while (cur != null) {
            stack.push(cur);
            next = cur.next;
            if (stack.size() == k) {
                if (tail == null){
                    newHead = cur;
                }
                tail = stackProcess(stack,tail,next);
            }
            cur = next;
        }
        return newHead;
    }

    private static ListNode stackProcess(Stack<ListNode> stack, ListNode tail, ListNode next) {
        ListNode cur = stack.pop();
        ListNode p = null;
        if (tail!=null){
            tail.next = cur;
        }
        while (!stack.isEmpty()){
            p = stack.pop();
            cur.next = p;
            cur = cur.next;
        }
        cur.next = next;
        return cur;
    }

    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next= new ListNode(6);
        head.next.next.next.next.next.next= new ListNode(7);
        head.next.next.next.next.next.next.next= new ListNode(8);
        //Node node = reverseKNode(head, 3);
        ListNode node = reverseKGroup(head,3);
        System.out.println(node);
    }
}
