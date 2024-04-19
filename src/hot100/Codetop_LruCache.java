package hot100;

import java.util.HashMap;

/**
 * 1、使用双向链表：因为在删除尾节点时， 要定位到上一个节点，不要遍历链表；
 * 2、为什么Node节点要存储 key+value, 因为在移除尾节点时，需要通过key删除map中的node
 */
public class Codetop_LruCache {

    static  class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node (int key, int value){
            this.key  = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public Codetop_LruCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        if (map.containsKey(key)){
            //节点移动到链表头
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.value;
        }

        return -1;
    }

    //需要同时更新map 和 链表
    public void put(int key, int value){
        if (map.containsKey(key)){
            //更新value,返回null, 移动到链表头部
            Node node = map.get(key);
            node.value = value;
            remove(node);
            add(node);
        } else {
            //新建一个节点，如果1、没达到最大容量，放到链表头, 放入map 2、达到最大容量 删除链表尾节点,删除map中的该节点，插入到头节点
            Node newNode = new Node(key, value);
            if (map.size() == capacity){
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            map.put(key, newNode);
            add(newNode);
        }
    }

    public void add(Node node){
        Node next = head.next;
        next.pre = node;
        node.next = next;
        head.next = node;
        node.pre = head;
    }

    public void remove(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        node.pre = null;
        node.next = null;
    }



}
