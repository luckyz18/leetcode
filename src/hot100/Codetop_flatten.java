package hot100;

public class Codetop_flatten {


     static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int val) { this.val = val; }
      }
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        //1. 左子树-》根的右节点， 根的左子树置空 2.根的右子树接到左子树的最右节点上
        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode mostRight = root;
        while(mostRight.right != null ){
            mostRight = mostRight.right;
        }
        mostRight.right = tempRight;
    }

    public static void main(String[] args){
        Codetop_flatten instance = new Codetop_flatten();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        instance.flatten(root);
        while(root != null){
            System.out.println(root.val);
            root = root.right;
        }
    }
}
