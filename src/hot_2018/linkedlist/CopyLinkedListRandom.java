package hot_2018.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带有随机指针的链表
 */
public class CopyLinkedListRandom {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur!= null){
            Node newNode = new Node(cur.val);
            map.put(cur,newNode);
            cur = cur.next;
        }
        cur = head;
        while (cur!= null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random  = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.random = head.next.next.next;
        head.next.next.random = head;

        Node node = copyRandomList(head);
        System.out.println();
    }
}
