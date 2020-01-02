package hot_2018.array;

/**
 * 旋转数组
 */
public class Rotate {
    //1.
    public void rotate(int[] nums, int k) {
        //k可以大于 len
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        if (k > len) {
            k = k % len;
        }
        int rS = len - k;
        reverseArray(nums, 0, rS - 1);
        reverseArray(nums, rS, len - 1);
        reverseArray(nums, 0, len - 1);
        System.out.println();
    }

    private void reverseArray(int[] nums, int l, int r) {
        while (l <= r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    //2.
    public void rotate2(int[] nums, int k){
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        if (k > len) {
            k = k % len;
        }

    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        rotate.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
