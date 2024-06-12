package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 多叉树，找到根节点到叶子节点的最短距离
 */
public class ZJ_2_MinDepth {

    class TreeNode {
        int val;
        List<TreeNode> children;

        public TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public class MinimumDepthOfTree {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.children.isEmpty()) {
                        return depth;
                    }
                    for (TreeNode child : node.children) {
                        queue.offer(child);
                    }
                }
                depth++;
            }

            return depth;
        }
    }
}
