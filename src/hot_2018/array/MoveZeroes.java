package hot_2018.array;

/**
 * 移动 0
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length ==0) return;
        int p =0;

        for (int i = 0; i <nums.length; i++) {
            if (nums[i]== 0){
                continue;
            }
            nums[p++] = nums[i];
        }
        while (p<nums.length){
            nums[p++] = 0;
        }
    }

    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[] {1,0,2,3,0,5,0,0,6});
    }
}
