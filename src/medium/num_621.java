package medium;

import java.util.*;

public class num_621 {
    public static class Solution {
        /**
         * 贪心策略  让重复次数最多的任务最先执行  每轮有（n+1）种任务执行
         *
         * @param tasks
         * @param n
         * @return
         */
        static public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c : tasks)
                map[c - 'A']++;
            Arrays.sort(map);
            int time = 0;
            while (map[25] > 0) {
                int i = 0;
                while (i <= n) {
                    if (map[25] == 0)
                        break;
                    if (i < 26 && map[25 - i] > 0)
                        map[25 - i]--;
                    time++;
                    i++;
                }
                Arrays.sort(map);
            }
            return time;
        }

        public static void main(String[] args) {
            char[] s = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
            leastInterval(s, 2);
        }
    }

    /**
     * 基于优先级队列的解法
     */
    public static int leastInterval2(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int l : temp)
                queue.add(l);
        }
        return time;
    }

    /**
     * 比较难的一种算法 思考
     *
     * @param args
     */
    public int leastInterval3(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;  //idle_slots剩余的块数
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    /**
     * 和上面的思想类似
     * 更加简洁一些
     * 保存的是所有的块数
     * @param args
     */
    /**
     * 解题思路：
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务，
     * 如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
     * 则retCount++ ==> A->B->X->A->B->X->A->B
     * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval4(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) return tasks.length;
        //步骤1
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        //步骤2
        Arrays.sort(counts);
        int maxCount = counts[25];
        int retCount = (maxCount - 1) * (n + 1) + 1;
        int i = 24;
        //步骤3
        while (i >= 0 && counts[i] == maxCount) {
            retCount++;
            i--;
        }
        //步骤4
        return Math.max(retCount, tasks.length);
    }

    /**
     * for test
     *
     * @param args
     */
    public static int leastInterval6(char[] tasks, int n) {
        int map[] = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i] - 'A']++;
        }

        int time = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : map) {
            if (f > 0) {
                queue.add(f);
            }
        }
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()){
                    if (queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    } else if (queue.peek() == 1) {
                        queue.poll();
                    }
                }
                time++;
                //最后一轮
                if (queue.isEmpty() && temp.size() == 0){
                    break;
                }
                i++;
            }
            for (int k : temp) {
                queue.add(k);
            }
        }
        return time;
    }


    public static void main(String[] args) {
        char[] s = new char[]{'A', 'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval6(s, 2) );
    }


}
