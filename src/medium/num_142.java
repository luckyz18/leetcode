package medium;

/**
 * 环形链表 II
 */
public class num_142 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 找第一个相遇的节点  fast slow 的初始位置有要求 ，跟是否有环不一样，是否有环快慢指针从哪里开始都可以
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }

        if (head.next.next == head){
            return head;
        }
        ListNode slow=head.next;
        ListNode fast = head.next.next;
        while (slow != fast){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next ;
        ListNode b  = detectCycle(head);
        System.out.println(b.val);
    }
}
