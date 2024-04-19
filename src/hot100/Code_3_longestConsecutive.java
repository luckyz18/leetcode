package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 */
public class Code_3_longestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longStream = 0;
        for (int num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            int currentStream = 0;
            int currentNum = num;
            while (numSet.contains(currentNum)) {
                currentStream++;
                currentNum += 1;
            }
            longStream = Math.max(currentStream, longStream);
        }
        return longStream;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {100,4,200,1,3,2};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }


}
