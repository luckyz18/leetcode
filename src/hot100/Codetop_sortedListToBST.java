package hot100;

/**
 * 有序链表转化为平衡二叉搜索树
 */
public class Codetop_sortedListToBST {
    static  class ListNode{
        int value;
        ListNode next ;
        public  ListNode(int value){
            this.value = value;
        }
    }

    static  class TreeNode{
        int value;
        TreeNode left ;
        TreeNode right ;
        public  TreeNode(int value){
            this.value = value;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode midNode = findMid(head);
        TreeNode root = new TreeNode(midNode.value);
        if(head == midNode){
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);
        return root;

    }

    private ListNode findMid(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow  = slow.next;
            fast = fast.next.next;
        }
        if (pre != null){
            pre.next = null;
        }
        return slow;
    }


}
