package easy;

/**
 * 二叉搜索树中的搜索
 */
public class num_700 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    //iterator
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);

        head.right = new TreeNode(7);

        TreeNode treeNode = searchBST(head, 2);
        System.out.println(treeNode.val);

    }
}
