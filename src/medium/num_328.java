package medium;

/**
 * 奇偶链表
 */
public class num_328 {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int x) {
            value = x;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode p = oddHead;
        ListNode evenHead = oddHead.next;
        ListNode q = evenHead;
        while (p != null && q != null) {
            p.next = q.next;
            p = q.next;
            if (p != null) {
                q.next = p.next;
                q = p.next;
            }
        }
        ListNode lastNode = findLastNode(oddHead);
        lastNode.next = evenHead;
        return oddHead;
    }

    public static ListNode findLastNode(ListNode head) {
        ListNode tmp = head;
        if (head == null) {
            return head;
        }
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp;
    }

    /**
     * 简洁版
     *
     * @param head
     * @return
     */
    public static  ListNode oddEvenList2(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


    public static void main(String[] args) {
        ListNode L1 = new ListNode(1);
        L1.next = new ListNode(2);
        L1.next.next = new ListNode(3);
        L1.next.next.next = new ListNode(4);
        /*L1.next.next.next.next = new ListNode(5);
        L1.next.next.next.next.next = new ListNode(6);
        L1.next.next.next.next.next.next = new ListNode(7);
        L1.next.next.next.next.next.next.next = new ListNode(8);*/
        oddEvenList2(L1);

    }
}
