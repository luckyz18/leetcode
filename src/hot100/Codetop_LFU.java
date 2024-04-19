package hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Codetop_LFU {
    public static  class Node{
        private int key;
        private  int value;
        private int frequency;

        public Node(int key, int value, int frequency ) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }

    }

    private Map<Integer, LinkedList<Node>> frequencyMap;
    private Map<Integer, Node> dataMap;
    private int minFrequency;
    private int capacity;
    public Codetop_LFU(int capacity){
        this.capacity = capacity;
        this.minFrequency = 0;
        this.dataMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0){
            return -1;
        }
        if (!dataMap.containsKey(key)){
            return -1;
        }
        //返回dataMap中node, frequencyMap找到旧频率中该节点，移除；-> 频率+1 的链表头
        Node node = dataMap.get(key);
        int fre = node.frequency;
        int value = node.value;
        LinkedList<Node> linkedList = frequencyMap.get(fre);
        linkedList.remove(node);
        //如果链表为空了 就删除key, 判断是否更新minFrequency
        if (linkedList.size() == 0){
            frequencyMap.remove(fre);
            if (minFrequency == fre){
                minFrequency = minFrequency + 1;
            }
        }
        LinkedList<Node> list = frequencyMap.getOrDefault(fre + 1, new LinkedList<>());
        node.frequency = node.frequency + 1;
        list.offerFirst(node);
        frequencyMap.put(fre + 1, list);
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0){
            return;
        }
        if (dataMap.containsKey(key)){
            //更新value, 移除旧频次上该节点, 插入fre+1的链表头 minFre也更新
            Node node = dataMap.get(key);
            node.value = value;
            int fre = node.frequency;
            LinkedList<Node> linkedList = frequencyMap.get(fre);
            linkedList.remove(node);
            if (linkedList.size() == 0){
                frequencyMap.remove(fre);
                if (minFrequency == fre){
                    minFrequency = minFrequency + 1;
                }
            }
            //插入fre+1节点的链表头
            LinkedList<Node> list = frequencyMap.getOrDefault(fre + 1, new LinkedList<>());
            node.frequency = fre+1;
            list.addFirst(node);
            frequencyMap.put(fre+1, list);
        } else {
            // 1. 容量如果超过，把freMap minFre移除尾结点, data移除 2. 写入map, fremap
            if (dataMap.size() == capacity){
                LinkedList<Node> nodes = frequencyMap.get(minFrequency);
                dataMap.remove(nodes.peekLast().key);
                nodes.pollLast();
                if (nodes.size() == 0){
                    frequencyMap.remove(minFrequency);
                }
            }
            //第一次加到 dataMap freMap
            LinkedList<Node> firstList = frequencyMap.getOrDefault(1, new LinkedList<>());
            Node newNode = new Node(key, value, 1);
            firstList.offerFirst(newNode);
            frequencyMap.put(1, firstList);
            dataMap.put(key, newNode);
            minFrequency = 1;
        }
    }
}
