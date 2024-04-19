package hot100;

/**
 * 移动0
 */
public class Code_4_moveZeroes {

    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int nonZeroIndex = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        for(int i = nonZeroIndex; i< nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println();
    }
}
