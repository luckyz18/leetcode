package easy;

/**
 * 二叉搜索树的范围和
 */
public class num_938 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int sum =0;
    public static int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        //看是否有L R这两个节点
        //中序遍历
        rangeSumBST(root.left, L,R);
        if (root.val >= L && root.val <= R){
            sum += root.val;
        }
        rangeSumBST(root.right,L,R);
        return sum;
    }

    public static int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) return 0; // base case.
        if (root.val < L) return rangeSumBST(root.right, L, R); // left branch excluded.
        if (root.val > R) return rangeSumBST(root.left, L, R); // right branch excluded.
        return root.val + rangeSumBST2(root.right, L, R) + rangeSumBST2(root.left, L, R); // count in both children.
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);

        int i = rangeSumBST(root, 6, 10);
        System.out.println(i);
    }
}
