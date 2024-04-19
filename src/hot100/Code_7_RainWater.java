package hot100;

import java.util.Stack;

public class Code_7_RainWater {


    private static int trap(int[] height){
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottomIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int leftIndex = stack.peek();
                int width = i - leftIndex - 1;
                int minHeight = Math.min(height[leftIndex], height[i]) - height[bottomIndex];
                result += width * minHeight;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height  = new int[] {4,2,0,3,2,5};
        int trap = trap(height);
        System.out.println(trap);
    }
}
