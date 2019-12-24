package hot_2018.before;

/**
 * 只出现一次的数字
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) throws Exception {
        if (nums == null || nums.length == 0){
            throw  new Exception("数组为空！");
        }
        int ret = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            ret = ret ^ nums[i];
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        int i = singleNumber(new int[]{2, 2, 1});
        System.out.println(i);
    }
}
