package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的满二叉树
 */
public class num_894 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //网上
    public List<TreeNode> allPossibleFBT(int N) {
        if (N <= 0 || N % 2 == 0) {
            return new ArrayList<>();
        }

        List<TreeNode>[] dp = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[1].add(new TreeNode(0));

        for (int numNode = 1; numNode <= N; numNode += 2) {
            for (int leftNode = 1; leftNode < numNode; leftNode += 2) {
                for (TreeNode left : dp[leftNode]) {
                    for (TreeNode right : dp[numNode - 1 - leftNode]) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        dp[numNode].add(root);
                    }
                }
            }
        }
        return dp[N];
    }

    //2.
    public List<TreeNode> allPossibleFBT2(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        N = N - 1;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = nl;
                    cur.right = nr;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
