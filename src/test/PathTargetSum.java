package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 美团一面， 二叉树路径和 = target
 */
public class PathTargetSum {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    public static List<List<Integer>> pathSum(TreeNode root, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, target, path, result);
        return result;

    }

    private static void dfs(TreeNode root, int target, List<Integer> path, List<List<Integer>> result) {
        if (root == null){
            return;
        }
        path.add(root.value);
        target -= root.value;
        if(root.left == null && root.right == null && target == 0){
            result.add(new ArrayList<>(path));
        } else {
            dfs(root.left, target, path, result);
            dfs(root.right, target, path, result);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left  = new TreeNode(2);
        root.right  = new TreeNode(3);
        root.left.left  = new TreeNode(4);
        List<List<Integer>> res = pathSum(root, 4);
        for (List<Integer> list : res) {
            System.out.println("[");
            for (Integer integer : list) {
                System.out.println(integer);
            }
            System.out.println("],");
        }
    }

}
