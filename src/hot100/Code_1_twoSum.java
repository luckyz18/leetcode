package hot100;

import java.util.HashMap;
import java.util.Map;

public class Code_1_twoSum {



    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {0};
    }

    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] ==  target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {0};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,95,4,-3};
        int target = 92;
        int[] res = twoSum1(nums, target);
        System.out.println("");
    }
}
