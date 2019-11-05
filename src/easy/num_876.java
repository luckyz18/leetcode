package easy;

public class num_876 {
    class ListNode{
        int value;
        ListNode next;
        ListNode(int x){
            value = x;
        }
    }
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p!= null){
            len += 1;
            p=p.next;
        }
        int mid = len/2;
        p = head;
        for (int i = 0; i <=mid ; i++) {
            if (i!= mid){
                p = p.next;
            }else{
                return p;
            }
        }
        return null;
    }

    //快慢指针
    public ListNode middleNode2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
