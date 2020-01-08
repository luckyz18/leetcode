package hot_2018.stack_queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口最大值
 */
public class MaxSlidWindow {
    private Deque<Integer> deque = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            //过期 poll
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //下标是否达到可以打印的边界
            if (i >= (k - 1)) {
                list.add(nums[deque.peekFirst()]);
            }
        }
        res = new int[list.size()];
        int index = 0;
        for (int tmp : list) {
            res[index++] = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSlidWindow A = new MaxSlidWindow();
        A.maxSlidingWindow(new int[]{1, -1}, 1);
        System.out.println();
    }
}
