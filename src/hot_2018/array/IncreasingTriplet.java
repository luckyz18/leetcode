package hot_2018.array;

/**
 * 递增的三元子序列
 * 不要求是连续的
 */
public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] <= min){  //!!! =号
                min = nums[i];
            }else if (nums[i] <= mid){   //!!! =号
                mid = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = increasingTriplet(new int[]{1,1,-2,6});
        System.out.println(b);
    }
}
