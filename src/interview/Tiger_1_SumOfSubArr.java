package interview;

import java.util.Stack;

public class Tiger_1_SumOfSubArr {
    public int sumOfSubArr(int[] nums){
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<n ; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n-1; i>=0 ; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int result = 0;
        for(int i = 0; i< n ; i++){
            result = result + nums[i] * (i - left[i]) * (right[i] - i);
        }
        return result;

    }

}
