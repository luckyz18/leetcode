package hot100;

/**
二叉树最大路径和
 */
public class Codetop_maxPathSum {
    static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    int maxPathSum = Integer.MIN_VALUE;

    public  int maxPathSum(TreeNode root) {
        mathPathSumHelper(root);
        return maxPathSum;
    }
    public  int mathPathSumHelper(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftMax = Math.max(mathPathSumHelper(node.left), 0);
        int rightMax = Math.max(mathPathSumHelper(node.right), 0);
        int newPathSum = node.val + leftMax + rightMax;
        maxPathSum = Math.max(maxPathSum, newPathSum);
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Codetop_maxPathSum instance = new Codetop_maxPathSum();
        int sum =   instance.maxPathSum(root);
        System.out.println("sum:" + sum);
    }
}
