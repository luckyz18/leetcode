package hot_2018.array;

/**
 * 乘积最大子序列
 */
public class MaxProduct {

    //暴力的方式 O(N^2)
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxRet = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            maxRet = Math.max(maxRet, tmp);
            for (int j = i + 1; j < nums.length; j++) {
                tmp *= nums[j];
                maxRet = Math.max(maxRet, tmp);
            }
        }
        return maxRet;
    }

    //dp  但是只保留了前一个状态的最大值和最小值
    //跟数组中连续子数组的最大和 相似
    //以 nums[i] 结尾的 最大最小乘积
    public static int maxProduct222(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int imax = nums[0];
        int imin = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                //swap(imax, imin);
                int tmp = imin;
                imin = imax;
                imax = tmp;
            }
            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);
            res = Math.max(res,imax);
        }
        return res;
    }

    //值传递。。。
    private static void swap(int imax, int imin) {
        int tmp = imin;
        imin = imax;
        imax = tmp;
    }


    public static void main(String[] args) {
        int i = maxProduct222(new int[]{-2,3, -4});
        System.out.println(i);
    }
}
