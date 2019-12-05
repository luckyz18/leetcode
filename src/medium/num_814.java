package medium;

public class num_814 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static TreeNode pruneTree(TreeNode root) {
        if (root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(0);
        head.left = new TreeNode(0);
        head.left.left = new TreeNode(0);
        head.left.left.right = new TreeNode(0);

        head.right = new TreeNode(0);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(1);
        TreeNode treeNode = pruneTree(head);
        System.out.println();
    }
}
