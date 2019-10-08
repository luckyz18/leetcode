package easy;

public class num_53 {
    //分治  有错误
    /*public static int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        return maxSubArray(nums,0,nums.length-1);
    }

    public static int getMax(int left,int right){
        if ( (left + right) > left  && (left + right)>right  ){
            return left+right;
        }else if (left > right){
            return left;
        }else{
            return right;
        }
    }

    public static int maxSubArray(int[] nums,int left,int right) {
        if (left == right){
            return nums[left];
        }
        int mid= left + (right - left)/2;
        int leftMax = maxSubArray(nums,left,mid);
        int rightMax = maxSubArray(nums,mid+1,right);
        return getMax(leftMax,rightMax);
    }*/
    /***************分治********************/
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }
    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    private int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;
        return max3(maxSubArraySum(nums, left, mid),
                maxSubArraySum(nums, mid + 1, right),
                maxCrossingSum(nums, left, mid, right));
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
    /***********************************/

    public static int maxSubArray(int[] nums) {
        int sum = 0;  //当前子序和
        int ans = nums[0];  //整个过程中的最大子序和
        for (int num : nums) {
            if (sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            ans = Math.max(sum,ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int t = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(t);
    }

}
