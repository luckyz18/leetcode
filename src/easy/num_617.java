package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 合并二叉树
 */
public class num_617 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 != null ? t1 : t2;
        }
        t2.val = t2.val + t1.val;
        t2.left = mergeTrees(t1.left, t2.left);
        t2.right = mergeTrees(t1.right, t2.right);
        return t2;
    }

    //非递归的写法
    // Method 3: Iterative BFS
    // Time: O(n)
    // Space: O(n)
    public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{t1, t2});
        while (!queue.isEmpty()) {
            TreeNode[] cur = queue.poll();
            // no need to merge t2 into t1
            if (cur[1] == null) {
                continue;
            }
            // merge t1 and t2
            cur[0].val += cur[1].val;
            // if node in t1 == null, use node in t2 instead
            // else put both nodes in stack to merge
            if (cur[0].left == null) {
                cur[0].left = cur[1].left;
            } else {
                queue.offer(new TreeNode[]{cur[0].left, cur[1].left});
            }
            if (cur[0].right == null) {
                cur[0].right = cur[1].right;
            } else {
                queue.offer(new TreeNode[]{cur[0].right, cur[1].right});
            }
        }
        return t1;
    }

    // Method 2: Iterative DFS
    // Time: O(n)
    // Space: O(height)
    public TreeNode mergeTrees3(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        // Use stack to help DFS
        Deque<TreeNode[]> stack = new LinkedList<>();
        stack.offerLast(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] cur = stack.pollLast();
            // no need to merge t2 into t1
            if (cur[1] == null) {
                continue;
            }
            // merge t1 and t2
            cur[0].val += cur[1].val;
            // if node in t1 == null, use node in t2 instead
            // else put both nodes in stack to merge
            if (cur[0].left == null) {
                cur[0].left = cur[1].left;
            } else {
                stack.offerLast(new TreeNode[]{cur[0].left, cur[1].left});
            }
            if (cur[0].right == null) {
                cur[0].right = cur[1].right;
            } else {
                stack.offerLast(new TreeNode[]{cur[0].right, cur[1].right});
            }
        }
        return t1;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(6);
        t1.right = new TreeNode(4);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(5);
        t2.left.left = new TreeNode(1);
        t2.left.right = new TreeNode(7);
        TreeNode treeNode = mergeTrees2(t1, t2);
        System.out.println();
    }

}
