package hard;

/**
 * 二叉树中的最大路径和
 */
public class num_124 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    //private static int maxLen;
    private static int maxLen = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        maxPathSum2(root);
        return maxLen;
    }

    private static int maxPathSum2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int lData = maxPathSum2(root.left);
        int rData = maxPathSum2(root.right);
        //计算以root为最高点的最长路径的长度，并和原先的最大值比较
        maxLen = Math.max(maxLen, Math.max(0,lData) + Math.max(0,rData) + root.val);
        //返回以root为起点的最长路径的长度
        return Math.max( Math.max(root.val+lData,root.val+rData), root.val );
    }

    public static void main(String[] args) {
        TreeNode head  = new TreeNode(-3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left= new TreeNode(15);
        head.right.right = new TreeNode(7);

        int i = maxPathSum(head);
        System.out.println(i);
    }

}

