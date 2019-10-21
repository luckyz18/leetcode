package easy;

import com.sun.javafx.collections.FloatArraySyncer;
import com.sun.org.apache.xpath.internal.functions.FuncCurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_229 {
    //摩尔投票  最多只有两个
    static class Solution {
        public static List<Integer> majorityElement(int[] nums) {
            List res = new ArrayList<Integer>();
            if (nums == null || nums.length < 2) {
                for (int i : nums) {
                    res.add(i);
                }
                return res;
            }
            int num1 = nums[0];
            int num2 = nums[0];
            int count1 = 0, count2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num1) {
                    count1++;
                } else if (nums[i] == num2) {
                    count2++;
                } else if (count1 == 0) {
                    num1 = nums[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    num2 = nums[i];
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
            count1 = 0;
            count2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num1) {
                    count1++;
                } else if (nums[i] == num2) {  //else 防止 【2,2】这种情况
                    count2++;
                }
            }
            if (count1 > nums.length / 3) {
                res.add(num1);
            }
            if (count2 > nums.length / 3) {
                res.add(num2);
            }
            return res;
        }

        //暴力
        public static List<Integer> majorityElement2(int[] nums) {
            List res = new ArrayList();
            if (nums == null || nums.length < 2) {
                for (int i : nums) {
                    res.add(i);
                }
                return res;
            }
            Arrays.sort(nums);
            int currNum = nums[0];
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == currNum) {
                    count++;
                    continue;
                } else if (count > nums.length / 3) {
                    res.add(currNum);
                }
                currNum = nums[i];
                count = 1;
            }
            if (count > nums.length/3){
                res.add(currNum);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = Solution.majorityElement2(new int[]{3,2,3});
        System.out.println(integers);
    }
}
