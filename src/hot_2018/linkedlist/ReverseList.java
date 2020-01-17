package hot_2018.linkedlist;

/**
 * 反转链表
 */
public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode p = newHead.next;
        ListNode cur = head;
        ListNode next = null;
        while (cur!= null){
            next = cur.next;
            cur.next = null;
            newHead.next = cur;
            cur.next = p;
            p = cur;
            cur = next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode listNode = reverseList(head1);
        System.out.println(listNode.val);

    }
}
