package hot100;
import java.util.*;

public class Code_FlextPort_merge_intervals {

    public static int[][] merge(int[][] a) {
        List<int[]> res = new ArrayList<int[]>();
        if (a.length == 0 )  {
            return new int[0][0];
        }
        Arrays.sort(a,(x, y) -> x[0] - y[0]); //lambda表达式排序
        int l = a[0][0], r = a[0][1];
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] > r) {
                res.add(new int[]{l, r});
                l = a[i][0];
                r = a[i][1];
            } else {
                r = Math.max(r, a[i][1]);
            }
        }
        res.add(new int[]{l,r});
        return  res.toArray(new int[res.size()][]);
    }

    public static int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparing(v->v[0]));
        List<int[]> res = new ArrayList<int[]>();
        res.add(new int[] {intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            if (intervals[i][0] <= last[1]){
                last[1] = Math.max(last[1], intervals[i][1]);
            } else{
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }
        List<int[]> res = new ArrayList<>();
        //没有交集， 不需要合并
        int[] mergedArr = null;
        for (int i = 0; i < intervals.length; i++) {
            boolean hasCross = hasCross(intervals[i], newInterval);
            if (!hasCross) {
                res.add(intervals[i]);
                continue;
            }
            if (mergedArr == null) {
                mergedArr = mergeTwoArr(intervals[i], newInterval);
            } else {
                mergedArr = mergeTwoArr(intervals[i], mergedArr);
            }
            if (i == intervals.length-1 || mergedArr[1] < intervals[i+1][0]){
                res.add(mergedArr);
            }
        }
        if (mergedArr == null){
            res.add(newInterval);
        }
        Collections.sort(res, Comparator.comparing(v -> v[0]));
        return res.toArray(new int[res.size()][]);
    }

    public static boolean hasCross(int[] arr1, int[] arr2){
        if (arr1[1] < arr2[0] || arr1[0] > arr2[1]){
            return false;
        }
        return true;
    }

    public static int[] mergeTwoArr(int[] interVal, int[] newInterval){
        int l = Math.min(interVal[0], newInterval[0]);
        int r = Math.max(interVal[1], newInterval[1]);
        return new int[] {l, r};
    }


    public static void main(String[] args) {
//        int [][] arr = new int[][] {{1,3},{2,6},{8,10},{15,18}};
//        int[][] merge = merge2(arr);
//        System.out.println(merge.toString());
        int [][] intervals = new int[][] {{1,5}};
        int [] newInterval = new int[] {6,8};
        int[][] insert = insert(intervals, newInterval);
        System.out.println();
    }



}
