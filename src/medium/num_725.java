package medium;

/**
 * 分隔链表
 */
public class num_725 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        int len = getLen(root);
        int groupLen = len / k;
        int yu = len % k;
        int[] arr = new int[k];
        ListNode[] res = new ListNode[k];
        ListNode p = root;
        for (int i = 0; i < arr.length; i++) {
            //每部分的长度
            if (yu > 0) {
                arr[i] = groupLen + 1;
                yu--;
            } else {
                arr[i] = groupLen;
            }
        }

        ListNode next = p;
        ListNode head, tail;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            head = tail = next;
            while (tail != null && count < arr[i]) {
                count++;
                tail = tail.next;
            }
            if (tail != null) {
                next = tail.next;
                tail.next = null;
                res[i] = head;
            } else {
                next = null;
                res[i] = null;
            }
        }
        return res;
    }

    public static int getLen(ListNode root) {
        int count = 0;
        ListNode p = root;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode L1 = new ListNode(1);
        L1.next = new ListNode(2);
        L1.next.next = new ListNode(3);

        splitListToParts(L1, 5);
    }

    //
    public ListNode[] splitListToParts2(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        for (ListNode i = root; i != null; i = i.next)
            len++;
        int size = len / k, rem = len % k;
        ListNode tmp = root;
        for (int i = 0; i < k; i++) {
            int newSize = i < rem ? size + 1 : size;
            ListNode l = tmp;
            for (int j = 1; j < newSize; j++, l = l.next) ;
            res[i] = tmp;
            if (l != null) {
                tmp = l.next;
                l.next = null;
            }
        }
        return res;
    }
}




