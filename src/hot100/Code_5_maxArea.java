package hot100;

/**
 * 盛最多水的容器
 */
public class Code_5_maxArea {

    public int maxArea(int[] height) {
        if(height == null || height.length == 0 || height.length == 1){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left < right){
            int currentArea = (right - left) * (Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}
