package medium;

/**
 * 二叉搜索树中的插入操作
 */
public class num_701 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    //非递归
    public static TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true){
            if (cur.val >= val){
                if (cur.left == null){
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            }else{
                if (cur.val < val){
                    if (cur.right == null){
                        cur.right = new TreeNode(val);
                        break;
                    }
                    cur = cur.right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        TreeNode treeNode = insertIntoBST2(root, 5);
        System.out.println();

    }
}
