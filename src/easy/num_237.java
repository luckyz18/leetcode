package easy;

public class num_237 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //因为我们无法获取之前的节点-没head 把下一个节点的值赋给它 然后删除下一个节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
