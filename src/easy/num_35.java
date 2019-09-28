package easy;

import java.util.Arrays;
import java.util.List;

public class num_35 {
    public static  int searchInsert(int[] nums, int target) {
        int i= 0;
        for (; i <nums.length; i++) {
            if (nums[i] < target){
                continue;
            }else if (nums[i] == target){
                return i;
            }else if (nums[i] > target){
                return i;
            }
        }
       return i;
    }

    //二分查找也可以不单独对mid 进行判断
    public static int searchInsert2(int[] nums, int target) {
       int left = 0;
       int right  = nums.length-1;
       while (left <= right){
           int mid = left + (right-left)/2;
           if (nums[mid] == target){
               return mid;
           }else if (nums[mid] > target){
               right = mid-1;
           }else if(nums[mid] < target){
               left = mid +1;
           }
       }
       return left;
    }

    public static void main(String[] args) {
        int y = searchInsert2(new int[] {1,3,5,6},5);
        System.out.println(y);
    }

}
