package hot_2018.stack_queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 未排序数组中第 K个最大元素
 */
public class FindKthLargest {
    //排序
    public static int findKthLargest(int[] nums, int k) {
        Integer[] help = new Integer[nums.length];
        int index = 0;
        for (int i : nums) {
            help[index++] = i;
        }
        Arrays.sort(help, Collections.reverseOrder());
        return help[k - 1];
    }

    //2. 剑指 offer上是   快排的思想  能确定第几个位置吗不是，对比是不是K ！
    public static int findKthLargest2(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int index = 0;
        while (l <= r) {   //!!! =号
            index = partation(nums, l, r);
            if (index == nums.length - k) {
                break;
            } else if (index < nums.length - k) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        return nums[index];
    }

    public static int partation(int[] nums, int l, int h) {
        int p = nums[l];
        int i = l;
        int j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) ;
            while (j != l && nums[--j] > p) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    //3.  借助堆换取时间复杂度O（N LogK）
    public static int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.isEmpty() || priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
            } else if (nums[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        //System.out.println(priorityQueue.peek());
        return priorityQueue.peek();
    }


    public static void main(String[] args) {
        int v = findKthLargest2(new int[]{2,1}, 2);
        System.out.println(v);
    }
}
