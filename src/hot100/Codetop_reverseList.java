package hot100;

/**
 * 翻转链表
 */
public class Codetop_reverseList {

    static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int value){
            this.val = value;
        }
    }


    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }


    public static ListNode reverseList2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode reverseHead = reverseList(head);
        System.out.println();
    }
}
