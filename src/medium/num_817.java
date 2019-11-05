package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num_817 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static int numComponents(ListNode head, int[] G) {
        ListNode p = head;
        List list = arrToList(G);
        int count = 0;
        while (p != null){
            if (list.contains(p.val)){
                count++;
                p=p.next;
                while(p != null && list.contains(p.val)){
                    p=p.next;
                }
            }else{
                p=p.next;
            }
        }
        return count;
    }

    public static List arrToList(int[] arr){
        List list = new ArrayList();
        for (int i = 0; i <arr.length ; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    //找尾巴节点  +1
    public int numComponents2(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet();
        for (int x: G)
            Gset.add(x);

        ListNode cur = head;
        int ans = 0;

        while (cur != null) {
            if (Gset.contains(cur.val) &&
                    (cur.next == null || !Gset.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);



    }
}
