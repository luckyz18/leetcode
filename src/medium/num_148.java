package medium;

/**
 * 排序链表
 */
public class num_148 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        ListNode[] arrNode = new ListNode[count];
        cur = head;
        for (int i = 0; i < arrNode.length; i++) {
            arrNode[i] = cur;
            cur = cur.next;
        }
        quicksort(arrNode, 0, arrNode.length - 1);
        //窜起来
        int i;
        for (i = 1; i != arrNode.length; i++) {
            arrNode[i - 1].next = arrNode[i];
        }
        arrNode[i - 1].next = null;
        return arrNode[0];
    }

    private static void quicksort(ListNode[] arrNode, int l, int r) {
        if (l < r) {
            swap(arrNode, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arrNode, l, r);
            quicksort(arrNode, l, p[0] - 1);
            quicksort(arrNode, p[1] + 1, r);
        }
    }

    private static int[] partition(ListNode[] arrNode, int left, int right) {
        int small = left - 1;
        int more = right;
        while (left < more) {
            if (arrNode[left].val < arrNode[right].val) {
                swap(arrNode, ++small, left++);
            } else if (arrNode[left].val > arrNode[right].val) {
                swap(arrNode, --more, left);
            } else {
                left++;
            }
        }
        swap(arrNode, more, right);
        return new int[]{small + 1, more};
    }

    public static void swap(ListNode[] arr, int i, int j) {
        int len = arr.length;
        if (i < arr.length && j < arr.length) {
            ListNode tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    /**
     * 归并法  时间O(nlogn)  空间 O(logn)
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中间节点  归并排序
        ListNode slow = head;
        ListNode fast = head;
        ListNode next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        next = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(next);
        return merge(l1, l2);

    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode l = tmp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        if (l1 != null) {
            l.next = l1;
        } else {
            l.next = l2;
        }
        return tmp.next;
    }

//参考的代码
   /* public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }*/


    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(8);
        head.next.next = new ListNode(4);
        sortList(head);
    }

}

