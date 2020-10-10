package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的最大深度
 */
public class num_104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDep = maxDepth(root.left);
        int rightDep = maxDepth(root.right);
        return Math.max(leftDep,rightDep) +1;
    }

    //大佬的非递归的解法
    //1. BFS
    public static int maxDep2(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0 ){
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right!= null){
                    queue.offer(poll.right);
                }
            }
            count++;
        }

        return count;
    }

    //2. DFS
    public static int maxDep3(TreeNode root){
        if (root == null){
            return 0;
        }
        //记录每一个节点所在的层
        Stack<TreeNode> nodeStack = new Stack();
        Stack<Integer> valueStack = new Stack<>();
        nodeStack.push(root);
        valueStack.push(1);
        int max = 0;
        while (!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            Integer value = valueStack.pop();
            max = Math.max(max,value);
            if (node.left!=null){
                nodeStack.push(node.left);
                valueStack.push(value +1);
            }
            if (node.right != null){
                nodeStack.push(node.right);
                valueStack.push(value +1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.left.left.left.right = new TreeNode(8);
        root.left.right = new TreeNode(5);


        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int i = maxDep3(root);
        System.out.println(i);
    }



}
