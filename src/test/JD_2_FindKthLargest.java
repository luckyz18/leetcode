package test;

import java.util.PriorityQueue;

/**
 * 给定一个数组nums, 找到其中第K大的数字， 要求时间复杂度 O(N)
 * 算法思路：第K大-> 小根堆， 保存前K个最大的数字，堆顶最小，每次跟堆顶比较，如果堆顶小于待比较的值，就进行交换。
 * 构建堆的时间复杂度：K * logK, 遍历数组O(N), K <=N , 时间复杂度近似为O（N）
 */
public class JD_2_FindKthLargest {
    public static Integer findKthLargestNum(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int num: nums){
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,1,5,12,2,11};
        Integer kthLargestNum = findKthLargestNum(nums, 4);
        System.out.println(kthLargestNum);
    }


}
