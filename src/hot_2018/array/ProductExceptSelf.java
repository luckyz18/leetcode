package hot_2018.array;

/**
 * 除自身以外数组的乘积
 * 空间 O（1）
 * 不可以用除法
 *  = 左积 * 右积
 */
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println();
    }
}
