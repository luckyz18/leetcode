package test;

/**
 * JD 三面： 合并两个有序链表，
 */
public class JD_3_mergeTwoSortedList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null? l2 : l1;
        }

        ListNode resultHead = null;
        ListNode current  = null;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                //这里要求不新增头结点实现
                if (current == null) {
                    current = l1;
                } else{
                    current.next = l1;
                    current = current.next;
                }
                l1 = l1.next;
            } else{
                if (current == null) {
                    current = l2;
                } else{
                    current.next = l2;
                    current = current.next;
                }
                l2 = l2.next;
            }
            resultHead = resultHead == null? current : resultHead;
            //current = current.next;
        }
        if(l1 != null){
            current.next = l1;
        } else{
            current.next = l2;
        }
        return resultHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoSortedList(l1, l2);
        ListNode cur = listNode;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}




