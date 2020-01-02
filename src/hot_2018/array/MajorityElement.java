package hot_2018.array;

/**
 * 多数元素
 */
public class MajorityElement {

    private boolean globalParam = false;

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            globalParam = true;
            return -1;
        }
        int sum = 0;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                ret = nums[i];
                sum += 1;
            } else {
                if (nums[i] == ret) {
                    sum++;
                } else {
                    sum--;
                }
            }
        }
        return ret;
    }
}
