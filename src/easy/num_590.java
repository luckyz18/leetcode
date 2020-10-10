package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
/*N叉树的后序遍历*/

public class num_590 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();
    public static List<Integer> postOrder(Node root) {
        if (root == null) {
            return list;
        }
        if (root.children!= null){
            List<Node> children = root.children;
            for (Node childNode : children) {
                postOrder(childNode);
            }
        }
        list.add(root.val);
        return list;
    }

    //非递归
    public static List<Integer> postOrder2(Node root) {
        Stack<Node> stack= new Stack();
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList();
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            list.add(pop.val);
            if (pop.children!= null && pop.children.size() > 0) {
                for (Node child : pop.children) {
                    stack.push(child);
                }
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        List<Node> l1 = new ArrayList<>();
        List<Node> l2 = new ArrayList<>();
        Node root = new Node(1);
        Node c1 = new Node(3);
        Node c2 = new Node(2);
        Node c3 = new Node(4);
        Node c4 = new Node(5);
        Node c5 = new Node(6);
        l1.add(c1);
        l1.add(c2);
        l1.add(c3);
        l2.add(c4);
        l2.add(c5);

        root.children = l1;
        c1.children = l2;

        List<Integer> integers = postOrder2(root);
        System.out.println(integers);
    }


}
