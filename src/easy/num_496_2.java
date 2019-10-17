package easy;

import sun.applet.Main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

//单调栈的模板
//单调栈一个是向前扫描 一个是向后扫描
// 单调栈解决 Next Greater Number 一类问题
public class num_496_2 {
    //从第一个元素入栈

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack();
        Map<Integer,Integer> map = new LinkedHashMap();

        for (int i = 0; i <nums2.length ; i++) {
            if (stack.isEmpty()){
                stack.push(nums2[i]);
            }else{
                while (!stack.isEmpty() &&    stack.peek() < nums2[i]){
                    int top = stack.pop();
                    map.put(top,nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        for (int i = 0; i <nums1.length ; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    //从最后一个元素入栈
    //参考
    /*vector<int> nextGreaterElement(vector<int>& nums) {
        vector<int> ans(nums.size()); // 存放答案的数组
        stack<int> s;
        for (int i = nums.size() - 1; i >= 0; i--) { // 倒着往栈里放
            while (!s.empty() && s.top() <= nums[i]) { // 判定个子高矮
                s.pop(); // 矮个起开，反正也被挡着了。。。
            }
            ans[i] = s.empty() ? -1 : s.top(); // 这个元素身后的第一个高个
            s.push(nums[i]); // 进队，接受之后的身高判定吧！
        }
        return ans;
    }*/
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[nums1.length];
        Map<Integer,Integer> map2 = new LinkedHashMap();
        for (int i = nums2.length-1; i >=0; i--) {
            while (!stack.isEmpty() && (stack.peek() < nums2[i])){
                stack.pop();
            }
            //ans[i] = stack.isEmpty()?-1:stack.peek();  //弹空说明后面没有比它大的  返回-1
            if (stack.isEmpty()){
                map2.put(nums2[i],-1);
            }else{
                map2.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i <nums1.length ; i++) {
            ans[i] = map2.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1= {4,1,2};
        int[] nums2= {1,3,4,2};
        int[] ints = nextGreaterElement2(nums1, nums2);
        System.out.println(ints);

    }
}
