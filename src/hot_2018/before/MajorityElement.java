package hot_2018.before;

/**
 * 多数元素
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int ret = nums[0];
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (sum == 0) {
                ret = nums[i];
                sum = 1;
                continue;
            }
            sum = nums[i] == ret ? sum+1 : sum-1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int i = majorityElement(new int[]{1, 2, 3, 2, 2});
        System.out.println(i);
    }
}
