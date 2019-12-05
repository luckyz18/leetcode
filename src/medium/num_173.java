package medium;

import java.util.Stack;

public class num_173 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private Stack<TreeNode> stack = new Stack();
    public num_173(TreeNode root) {
        pushLeft( root);
    }

    private void pushLeft(TreeNode root) {
       TreeNode cur = root;
       while (cur != null){
           stack.push(cur);
           cur = cur.left;
       }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode pop = stack.pop();
        pushLeft(pop.right);
        return pop.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() ;
    }


}
