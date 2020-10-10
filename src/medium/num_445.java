package medium;

import java.util.Stack;
//两数相加 II
public class num_445 {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int x) {
            value = x;
        }
    }

    /**
     * 没过 空指针  ？
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverL1 = reverseList(l1);
        ListNode reverL2 = reverseList(l2);
        int resValue;
        int s;
        ListNode res = null;
        ListNode head = null;

        while (reverL1 != null && reverL2 != null) {
            int sum = reverL1.value + reverL2.value;
            resValue = sum % 10;
            s = sum / 10;
            if (head == null) {
                res = new ListNode(resValue + s);
                head = res;
            } else {
                res.next = new ListNode(resValue + s);
            }
            res = res.next;
            reverL1 = reverL1.next;
            reverL2 = reverL2.next;
        }
        if (reverL1 != null) {
            res.next = reverL1;
        }
        if (reverL2 != null) {
            res.next = reverL2;
        }
        return reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    /**
     * 栈
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null) {
            stack1.push(p1.value);
            p1 = p1.next;
        }
        while (p2 != null) {
            stack2.push(p2.value);
            p2 = p2.next;
        }
        ListNode head = null;
        int topSum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()){
                topSum += stack1.pop();
            }
            if (!stack2.isEmpty()){
                topSum += stack2.pop();
            }
            //***************
            ListNode p  = new ListNode(topSum % 10);
            p.next = head;
            head = p;
            topSum /= 10;
        }
        if (topSum != 0){
            ListNode p  = new ListNode(topSum );
            p.next = head;
            head = p;
        }
        return head;
    }

    //递归 ?/
    public static ListNode addTwoNumbers22(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }
        ListNode ans =  recur(l1, l2, len1, len2);
        return ans.value == 0 ? ans.next : ans;
    }

    public static ListNode recur(ListNode l1, ListNode l2, int len1, int len2)
    {
        if (l1 == null && l2 == null) {
            return new ListNode(0);
        }
        ListNode l,next;
        int val=0;
        if (len1 == len2) {
            next = recur(l1.next, l2.next, len1 - 1, len2 - 1);
            val = l1.value + l2.value+next.value;
        } else if (len1 > len2) {
            next = recur(l1.next, l2, len1 - 1, len2);
            val = l1.value+next.value;
        } else {
            next = recur(l1, l2.next, len1, len2 - 1);
            val = l2.value+next.value;
        }
        next.value = val % 10;
        val/=10;
        l = new ListNode(val);
        l.next = next;
        return l;
    }

    public static void main(String[] args) {

        ListNode L1 = new ListNode(7);
        L1.next = new ListNode(2);
        L1.next.next = new ListNode(4);
        L1.next.next.next = new ListNode(3);

        ListNode L2 = new ListNode(5);
        L2.next = new ListNode(6);
        L2.next.next = new ListNode(4);

        addTwoNumbers22(L1,L2);

    }
}


