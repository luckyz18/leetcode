package hot_2018.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的序列化和反序列化
 */
public class SerializeAndDeserialize {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //先序序列化
    //递归更简洁
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuffer sb = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            //visit
            if (pop == null) {
                sb.append("#!");
            } else {
                sb.append(pop.val + "!");
                stack.push(pop.right);
                stack.push(pop.left);
            }
        }
        return sb.toString();
    }

    public static String serialize2(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(root.val + "!");
        sb.append(serialize2(root.left));
        sb.append(serialize2(root.right));
        return sb.toString();
    }

    //先序反序列化
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] split = data.split("!");
        Queue<String> queue = new LinkedList();
        for (int i = 0; i < split.length; i++) {
            queue.offer(split[i]);
        }
        return deserializeByPre(queue);
    }

    private static TreeNode deserializeByPre(Queue<String> queue) {
        String pollString = queue.poll();
        TreeNode root = generateNode(pollString);
        if (root == null) {
            return null;
        }
        root.left = deserializeByPre(queue);
        root.right = deserializeByPre(queue);
        return root;
    }


    private static TreeNode generateNode(String poll) {
        if ("#".equals(poll)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(poll));
    }

    /************************************************/
    //层次序列化和反序列化
    public String serializeByLevel(TreeNode root) {
        if (root == null) return "#!";
        Queue<TreeNode> queue = new LinkedList();
        StringBuffer sb = new StringBuffer();
        sb.append(root.val + "!");
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
                sb.append(poll.left.val + "!");
            } else {
                sb.append("#!");
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                sb.append(poll.right.val + "!");
            } else {
                sb.append("#!");
            }
        }
        return sb.toString();
    }

    //层次反序列化
    public static TreeNode deserialize2(String data) {
        if (data == null || data.length() ==0 ) return null;
        String[] split = data.split("!");
        Queue<TreeNode> queue = new LinkedList();
        int index  =0;
        TreeNode root = generateNode(split[index++]);
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            poll.left = generateNode(split[index++]);
            poll.right = generateNode(split[index++]);
            if (poll.left!= null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        //TreeNode root = new TreeNode(3);
        //root.left = new TreeNode(5);
        //root.left.left = new TreeNode(6);
        //root.left.right = new TreeNode(2);
        //root.left.right.left = new TreeNode(7);
        //root.left.right.right = new TreeNode(4);
        //root.right = new TreeNode(1);
        //root.right.left = new TreeNode(0);
        //root.right.right = new TreeNode(8);
        //
        //String serialize = serialize(root);
        //System.out.println(serialize);
        //String s = serialize2(root);
        //System.out.println(s);

        TreeNode deserialize = deserialize2("1!2!3!4!#!#!5!#!#!#!#!");
        System.out.println();


    }
}
