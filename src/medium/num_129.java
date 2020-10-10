package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树数字路径之和
 * 微信面试题
 */
public class num_129 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> sumList = new ArrayList<>();
        int sum = 0;
        findPathSum(root,sumList,sum);
        int ret = 0;
        for (int i = 0; i < sumList.size(); i++) {
            ret += sumList.get(i);
        }
        return ret;
    }

    private static void findPathSum(TreeNode root, List<Integer> sumList,int sum) {
        if (root == null){
            return;
        }
        sum = sum * 10 + (root.val);
        boolean isLeaf = root.left == null && root.right ==null;
        if (isLeaf){
            sumList.add(sum);
        } else{
             findPathSum(root.left,sumList,sum);
             findPathSum(root.right,sumList,sum);
        }
    }

    //2. 比较好的解法  时间O(N) 空间O(logN)
    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i){
        if (root == null) {
            return 0;
        }
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }

    //3.DFS 先序遍历
    int res = 0;
    public int sumNumbers3(TreeNode root){
        preOrder(root,0);
        return res;
    }
    public void preOrder(TreeNode root, int val){
        if(root != null){
            // 值先乘10，后相加
            int tmp = val * 10 + root.val;

            // 当前节点是叶子节点
            if(root.left == null && root.right == null){
                res += tmp;
            } else {
                // 当前节点的左子节点不为空，继续递归，val的值是父节点的值，也就是tmp
                if(root.left != null){
                    preOrder(root.left, tmp);
                }
                if(root.right != null){
                    preOrder(root.right, tmp);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        int t = sumNumbers(root);
    }

}
