package hot_2018.linkedlist;

/**
 * 排序链表  时间复杂度是O(n logN )
 * 空间是 O(logN)
 */
public class SortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //归并
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(next);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode l = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val){
                l.next = l1;
                l1 = l1.next;
            }else{
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        if (l1!= null) {
            l.next = l1;
        }
        if (l2!= null) {
            l.next = l2;
        }
        return newHead.next;
    }
}
