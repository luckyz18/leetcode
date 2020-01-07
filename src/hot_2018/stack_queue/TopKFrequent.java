package hot_2018.stack_queue;

import java.util.*;

/**
 * 前 K 个高频元素
 * 时间复杂度必须优于O(N*logN)
 * O(N * logK)
 */
public class TopKFrequent {
    private Map<Integer, Integer> countMap = new HashMap<>();
    //建一个小根堆 放最多的K个数
    private PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return countMap.get(o1) - countMap.get(o2);
        }
    });

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int tmp : nums) {
            countMap.put(tmp, countMap.getOrDefault(tmp, 0) + 1);
        }
        for (int i : countMap.keySet()) {
            /*if (heap.size() < k) {
                heap.offer(i);
            } else if (countMap.get(i) > countMap.get(heap.peek())) {
                heap.offer(i);
                heap.poll();
            }*/
            //简化
            heap.offer(i);
            if (heap.size() > k){
                heap.poll();
            }
        }
        while (heap.size() > 0) {
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new TopKFrequent().topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 4, 4}, 2);
        System.out.println(list);
    }
}
