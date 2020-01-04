package hot_2018.stack_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 左边是大根堆 ： 放小的数
 * 右边是小根堆 ： 放大的数
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        //接口匿名类 直接实现一个接口。但是是匿名的
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }

    public void addNum(int num) {
        //奇数插入到小根堆
        //偶数插入到大根堆
        if (((minHeap.size() + maxHeap.size()) & 1) == 0) {
            //先跟小根堆的堆顶比较一下
            if (minHeap.size() > 0 && num > minHeap.peek()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
            }
        } else {
            if (maxHeap.size() > 0 && num < maxHeap.peek()) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            } else {
                minHeap.offer(num);
            }
        }
    }

    public  double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if ((size & 1) == 0) {
            return ((maxHeap.peek() + minHeap.peek()) * 1.0) / 2;
        } else {
            return maxHeap.peek() * 1.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder A = new MedianFinder();
        A.addNum(1);
        A.addNum(2);
        //A.addNum(3);
        double median = A.findMedian();
        System.out.println(median);
    }


}
