package easy;

//两数之和
public class num_1 {
    public static  int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i =0; i < nums.length;i++){
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] res1 = twoSum(nums,target);
        for (int i:
             res1) {
            System.out.print(i+" ");
        }
    }
}
