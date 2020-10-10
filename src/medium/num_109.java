package medium;

/**
 *
 * 有序链表转换二叉搜索树
 */
public class num_109 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        p = head;
        int[] arr = new int[count];
        int index = 0;
        while (p != null) {
            arr[index++] = p.val;
            p = p.next;
        }
        //根据中序  建树
        TreeNode root = generateBST(arr, 0, arr.length - 1);
        return root;
    }

    private static TreeNode generateBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode head = new TreeNode(arr[mid]);
        /* 可加可不加  Base case for when there is only one element left in the array
            if (start == end){
                return head;
            }
        */
        head.left = generateBST(arr, start, mid - 1);
        head.right = generateBST(arr, mid + 1, end);
        return head;
    }


    public static void main(String[] args) {
        //generateBST(new int[] {1,2,3,4,5} , 0, 4);
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        sortedListToBST(head);
    }

}
