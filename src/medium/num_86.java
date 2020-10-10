package medium;
//分隔链表
public class num_86 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lessH = null;
        ListNode lessT = null;
        ListNode moreAndEqualH = null;
        ListNode moreAndEqualT = null;
        ListNode next ;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (lessH == null) {
                    lessH = head;
                    lessT = head;
                } else {
                    lessT.next = head;
                    lessT = lessT.next;
                }
            } else {
                if (moreAndEqualH == null) {
                    moreAndEqualH = head;
                    moreAndEqualT = head;
                } else {
                    moreAndEqualT.next = head;
                    moreAndEqualT = moreAndEqualT.next;
                }
            }
            head = next;
        }
        // merge
       /* if (lessH == null) {
            return moreAndEqualH;
        }
        lessT.next = moreAndEqualH;
        return lessH;*/
       // 改写
        if (lessT != null){
            lessT.next = moreAndEqualH;
        }
        return lessH != null ? lessH : moreAndEqualH;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        partition(head,3);
    }
}
