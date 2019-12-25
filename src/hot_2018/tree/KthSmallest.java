package hot_2018.tree;

import java.util.Stack;

/**
 * BST 的第K小元素
 */
public class KthSmallest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        //中序遍历
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (++count == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }
}
