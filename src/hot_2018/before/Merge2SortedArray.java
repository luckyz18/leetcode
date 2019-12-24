package hot_2018.before;

/**
 * 合并两个排序数组
 */
public class Merge2SortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) {
            return;
        }
        int q = m + n - 1;
        int p = m - 1;
        int k = n - 1;
        while (k >= 0  && q > p) {
            if (p >= 0) {
                nums1[q--] = nums1[p] >= nums2[k] ? nums1[p--] : nums2[k--];
            }else{
                nums1[q--] = nums2[k--];
            }
        }
        for (int i : nums1) {
            System.out.print(i + "  ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[5];
        merge(nums1, 0, new int[]{1}, 1);
        System.out.println();
    }
}
