package medium;

import java.util.HashMap;
import java.util.Map;
//从链表中删去总和值为零的连续节点
public class num_1171 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 数组前缀和
     *
     * @param head
     * @return
     */
    public static ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode headPre = new ListNode(0); //!!!
        headPre.next = head;
        ListNode cur = headPre;
        HashMap map = new HashMap();
        int sum = 0;
        while (cur != null) {
            sum += cur.val;  //!!! 这里把 0 放进去，这样就可以把 【1，-1 】这样的删除
            if (!map.containsKey(sum)) {
                map.put(sum, cur);
            } else {
                ListNode samePre = (ListNode) map.get(sum);
                //需要在map中把之间的节点删除掉，否则影响之后的判断
                ListNode p = samePre.next;
                int count = sum + p.val;
                while (count != sum) {
                    map.remove(count);
                    p = p.next;
                    count += p.val;
                }
                samePre.next = cur.next;
            }
            cur = cur.next;
        }
        return headPre.next;
    }

    /**
     * 参考网上
     * @param head
     * @return
     */
    public static ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int prefix = 0;
        Map<Integer, ListNode> m = new HashMap<>();
        while (cur != null) {
            prefix += cur.val;
            if (m.containsKey(prefix)) {
                cur =  m.get(prefix).next;
                int p = prefix + cur.val;
                while (p != prefix) {
                    m.remove(p);
                    cur = cur.next;
                    p += cur.val;
                }
                m.get(prefix).next = cur.next;
            } else {
                m.put(prefix, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(-1);
        //head.next.next = new ListNode(2);
        //head.next.next.next = new ListNode(-3);
        //head.next.next.next.next = new ListNode(-2);
        //head.next.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next.next.next = new ListNode(-5);
        //head.next.next.next.next.next.next.next.next = new ListNode(1);

        ListNode listNode = removeZeroSumSublists(head);
        System.out.println(listNode);
    }
}
