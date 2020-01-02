package hot_2018.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 存在重复数组
 */
public class ContainsDuplicate {
    //空间复杂度 用hashset更好
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    //时间 可以循环两次O(N ^ 2)  空间 O(1)

    //时间上 O(NlogN) 空间 O(1)  先排序
    //时间上 O(N) O(N ) 不用hashmap 应该用hashset

    //2.
    public boolean containsDuplicate2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int b : nums) {
            if (b < min) {
                min = b;
            }
            if (b > max) {
                max = b;
            }
        }
        boolean a[] = new boolean[max - min + 1];
        for (int b : nums) {
            if (a[b - min]) {
                return true;
            } else {
                a[b - min] = true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        boolean b = new ContainsDuplicate().containsDuplicate(new int[]{1, 2, 3});
        System.out.println(b);
    }
}
