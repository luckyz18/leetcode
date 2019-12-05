package medium;

public class num_1008 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //时间 平均 O(n * logn)， 最坏的 o(n ^ 2) 二分查找排好了序
    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i <preorder.length ; i++) {
            findLocation(root,preorder[i]);
        }
        return root;
    }

    private static void findLocation(TreeNode root, int num) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null){
            pre = cur;
            if (num < cur.val){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        cur = new TreeNode(num);
        if (cur.val < pre.val){
            pre.left = cur;
        }else {
            pre.right = cur;
        }
    }
    // 同 findLocation
    public static void insertIntoBSThelper(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                TreeNode right = new TreeNode(val);
                root.right = right;
                return;
            } else {
                insertIntoBSThelper(root.right, val);
            }
        } else {
            if (root.left == null) {
                TreeNode left = new TreeNode(val);
                root.left = left;
                return;
            } else {
                insertIntoBSThelper(root.left, val);
            }
        }
    }

    //2.
    int index = 0;
    public TreeNode bstFromPreorder2(int[] preorder) {
        return getPreOrderNode(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode getPreOrderNode(int[] preorder, int min, int max) {
        if(index >= preorder.length) {
            return null;
        }
        if(preorder[index] < min || preorder[index] > max) {
            return null;
        }
        int val = preorder[index];
        TreeNode node = new TreeNode(val);
        index++;
        node.left = getPreOrderNode(preorder, min, val);
        node.right = getPreOrderNode(preorder, val, max);

        return node;
    }
    
    // 3.  和 2 一样
    int i = 0;
    public TreeNode bstFromPreorder3(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound)
            return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println();
    }
}
