package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化和反序列化二叉树
 */
public class num_449 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //先序遍历的方式序列化和反序列化
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = "";
        res = root.val + "!";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // 反建先序  二叉树
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] value = data.split("!");
        for (String s : value) {
            queue.offer(s);
        }
        return reConByPreOrder(queue);
    }

    private TreeNode reConByPreOrder(Queue<String> queue) {
        if (!queue.isEmpty()){
            String poll = queue.poll();
            if (poll.equals("#")) {
                return null;
            }
            TreeNode head = new TreeNode(Integer.parseInt(poll));
            head.left = reConByPreOrder(queue);
            head.right = reConByPreOrder(queue);
            return head;
        }
        return null;
    }

    /**
     * 层次遍历序列化和反序列化
     */
    public String serialize2(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        StringBuilder res = new StringBuilder(root.val + "!");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                res.append(node.left.val).append("!");
                queue.add(node.left);
            } else {
                res.append("#!");
            }
            if (node.right != null) {
                res.append(node.right.val).append("!");
                queue.add(node.right);
            } else {
                res.append("#!");
            }
        }
        return res.toString();
    }

    public static TreeNode deserialize2(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] value = data.split("!");
        int index = 0;
        TreeNode head = generateNode(value[index++]);
        Queue<TreeNode> queue = new LinkedList();
        if (head != null) {
            queue.offer(head);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = generateNode(value[index++]);
            node.right = generateNode(value[index++]);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }

    private static TreeNode generateNode(String s) {
        if (s.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(s));
    }

    public static void main(String[] args) {
        TreeNode res = deserialize2("1!2!3!4!#!#!5!#!#!#!#!");
        System.out.println();
    }


}
