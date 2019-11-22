package easy;

/**
 * . 环形链表
 */
public class num_141 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null ){
            return false;
        }
        if (head.next == head){
            return true;
        }
        if (head.next == null){
            return false;
        }
        if (head.next.next == null){
            return false;
        }
        //
        ListNode slow= head.next;
        ListNode fast = head.next.next;
        while (fast != slow){
            if (fast.next == null || fast.next.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
         head.next = new ListNode(2);
         //head.next.next = new ListNode(3);
         //head.next.next.next = new ListNode(4);
         //head.next.next.next.next = head.next ;
        boolean b = hasCycle(head);
        System.out.println(b);
    }
}
