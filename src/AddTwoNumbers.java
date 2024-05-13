/**
 * 两个单链表相加，
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public  static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 哑节点作为辅助
        ListNode p1 = l1, p2 = l2, current = dummyHead;
        int carry = 0; // 进位

        while (p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.val : 0; // 如果p1为空，x=0
            int y = (p2 != null) ? p2.val : 0; // 如果p2为空，y=0
            int sum = carry + x + y;
            carry = sum / 10; // 计算新的进位

            current.next = new ListNode(sum % 10); // 创建新节点存储当前位结果
            current = current.next; // 移动到新节点

            if (p1 != null) p1 = p1.next; // 移动p1到下一个节点
            if (p2 != null) p2 = p2.next; // 移动p2到下一个节点
        }

        // 检查最终进位
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next; // 返回结果链表的头节点，忽略哑节点
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 反转链表
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode dummyHead = new ListNode(0); // 创建一个哑节点作为结果链表的头
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10; // 计算进位
            current.next = new ListNode(sum % 10); // 创建新节点并加入结果链表
            current = current.next;
        }

        if (carry > 0) { // 处理最后的进位
            current.next = new ListNode(carry);
        }

        // 这里可以选择是否再次反转链表，以保持与原始输入相同的顺序
        // current = reverseList(dummyHead.next);

        return dummyHead.next; // 返回结果链表，忽略哑节点
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next  = new ListNode(2);
        head1.next.next  = new ListNode(3);

        ListNode head2 = new ListNode(1);
        head2.next  = new ListNode(7);

        ListNode listNode = addTwoNumbers2(head1, head2);
        System.out.println();
    }
}
