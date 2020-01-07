package hot_2018.stack_queue;

import java.util.PriorityQueue;

public class KthSmallest_2 {

    /**
     * 先存上第一行  后来把每一行的下一个数压进去
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(int j = 0; j <= n-1; j++)
            pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }

    //static class Tuple implements Comparable<Tuple> {
    //    int x, y, val;
    //    public Tuple (int x, int y, int val) {
    //        this.x = x;
    //        this.y = y;
    //        this.val = val;
    //    }
    //    @Override
    //    public int compareTo (Tuple that) {
    //        return this.val - that.val;
    //    }
    //}

    static class Tuple{
        int x, y, val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }


    public static void main(String[] args) {
        int i = kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8);
        System.out.println(i);
    }
}
