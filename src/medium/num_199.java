package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num_199 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static List<Integer> list = new ArrayList<>();

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return list;
        }
        //层次遍历 最后一个节点
        TreeNode last = root;
        TreeNode nLast = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left!= null){
                queue.add(node.left);
                nLast= node.left;
            }
            if (node.right!= null){
                queue.add(node.right);
                nLast = node.right;
            }
            if (node == last ){
                list.add(node.val);
                last = nLast;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.right = new TreeNode(5);
        head.left.right.left = new TreeNode(6);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(4);

        List<Integer> integers = rightSideView(head);
        System.out.println();
    }
}
