package hot_2018.linkedlist;

/**
 * 奇偶链表
 */
public class OddEven {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode evenHead = head.next;
        ListNode even = head.next, odd = head;
        while (even!= null && even.next!= null){
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next= evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        oddEvenList(head);
    }

}
