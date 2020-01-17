package hot_2018.linkedlist;

/**
 * 相交链表
 */
public class IntersectionNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int count = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1.next != null) {
            count++;
            p1 = p1.next;
        }
        while (p2.next != null) {
            count--;
            p2 = p2.next;
        }
        if (p1 != p2) {
            return null;
        }
        p1 = headA;
        p2 = headB;
        if (count > 0) {
            while (count != 0){
                p1 = p1.next;
                count--;
            }
        } else if (count < 0) {
            count = Math.abs(count);
            while (count != 0){
                p2 = p2.next;
                count--;
            }
        }
        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(4);

        ListNode head2 = new ListNode(3);
        head2.next = head1.next.next.next;
        head2.next.next =  head1.next.next.next.next;

        ListNode node = getIntersectionNode(head1, head2);
        System.out.println(node.val);

    }
}
