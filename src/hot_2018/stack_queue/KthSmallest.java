package hot_2018.stack_queue;

import java.util.*;

/**
 * 有序矩阵中第K小的元素
 * 之后这种第K小或者第K大的数的解法：
 *      1: 堆
 *      2：二分查找（需要数据本身有序）
 *      3：快排
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(k - 1);
    }

    //优先级队列
    //大根堆 放最小的 K 个数
    public static int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (queue.size() < k) {
                    queue.offer(matrix[i][j]);
                } else if (matrix[i][j] < queue.peek()) {
                    queue.offer(matrix[i][j]);
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

    //二分查找  一种新思路确定第K小/ 大
    // right 一定在矩阵中 找到后count  >= k 并没有立即返回  所以最后left == right 的一定是矩阵中的元素

    /**
     * Solution 2 : Binary Search
     * We are done here, but let's think about this problem in another way:
     *  The key point for any binary search is to figure out the "Search Space".
     *  For me, I think there are two kind of "Search Space" -- index and range(the range from the smallest number to the biggest number).
     *  Most usually, when the array is sorted in one direction, we can use index as "search space",
     *  when the array is unsorted and we are going to find a specific number, we can use "range".
     */

    public static int kthSmallest3(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];

        while (left < right) {         //!!!
            int mid = (left + right) / 2;
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    private static int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {  //!!! 这里要有=
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        kthSmallest2(new int[][]{{1, 2}, {1, 3}}, 2);
    }
}
