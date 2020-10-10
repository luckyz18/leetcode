package medium;

import java.util.Deque;
import java.util.LinkedList;

//最大二叉树
public class num_654 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    private static TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (nums == null || left>right){
            return null;
        }
        int maxValue;
        int location;
        int[] res = getMax(nums,left,right);
        maxValue = res[0];
        location = res[1];
        TreeNode root= new TreeNode(maxValue);
        root.left = constructMaximumBinaryTree(nums,left,location-1);
        root.right = constructMaximumBinaryTree(nums,location+1,right);
        return root;
    }

    private static int[] getMax(int[] nums,int left,int right) {
        if (!(nums.length>0) || left > right){
            return null;
        }
        int maxValue = nums[left];
        int location = left;
        int[] res = new int[2];
        if (right-left > 0) {
            for (int i = left+1; i <= right; i++) {
                maxValue = maxValue > nums[i] ? maxValue : nums[i];
                location = maxValue > nums[i] ? location : i;
            }
        }
        res[0] = maxValue;
        res[1] = location;
        return res;
    }

    //网上的解法
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        //双端队列 是一种具有队列和栈的性质的数据结构
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }


    public static void main(String[] args) {
        int[] arr = new int[] {3,2,1,6,0,5};
        TreeNode node = constructMaximumBinaryTree(arr);
        System.out.println("");
    }

}
