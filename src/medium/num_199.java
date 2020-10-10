package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 */
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
            if (node == last ){    //遍历层的最后一个节点  这里可以做点手脚 当换行的时候 那么下一次弹出的一定是第一个节点（找最左的时候）
                list.add(node.val);
                last = nLast;
            }
        }
        return list;
    }

    // 层次遍历中用size 分层
    public List<Integer> rightSideView3(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size -- > 0){
                TreeNode cur = queue.poll();
                if (size == 0) {   //只要最后一个节点可以这么写 第一个节点就不好说了，可以用另一个变量存 然后跟size 比较，
                    res.add(cur.val);
                }
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return res;
    }

    //一种巧妙的思想  还是层次遍历比较好理解
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public static void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.right = new TreeNode(5);
        head.left.right.left = new TreeNode(6);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(4);

        List<Integer> integers = rightSideView2(head);
        System.out.println();
    }
}
