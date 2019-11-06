package medium;


public class num_24 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p, q;
        p = head;
        q = p.next;
        ListNode next;
        ListNode resHead = q;
        ListNode pre = p ;
        while (p != null && q != null) {
            next = q.next;
            q.next = null;
            p.next = null;
            q.next = p;
            pre = p;
            p = next;
            if (p != null) {
                q = p.next;
            } else {
                q = null;
            }
            pre.next = q;
        }
        if (p != null){
            pre.next = p;
        }

        return resHead;
    }

    //递归的解法
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    //非递归
    public ListNode swapPairs3(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            //初始化 start  end
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);

        swapPairs(head);

    }
}
