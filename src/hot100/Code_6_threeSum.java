package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class Code_6_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for(int i=0; i< nums.length-2; i++ ){
            //去重
            if(i> 0 && nums[i] == nums[i-1] ){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    resList.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    //去重
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left ++;
                    right --;
                } else if (sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return resList;
    }
}
