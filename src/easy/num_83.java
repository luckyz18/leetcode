package easy;

import javax.swing.undo.CannotUndoException;

public class num_83 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode p = cur.next;
        while (cur != null) {
            while (p!= null && cur.val == p.val){
                p = p.next;
            }
            cur.next = p;
            cur = p;
            if (cur!=null){
                p = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        deleteDuplicates(head);
    }
}
