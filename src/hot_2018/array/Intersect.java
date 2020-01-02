package hot_2018.array;

import java.util.*;

/**
 * 两个数组的交集
 */
public class Intersect {
    //时间复杂度O(n^2) 空间复杂度也不好
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ret;
        List<Integer> list = new ArrayList<>();
        boolean[] mask = new boolean[len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] == nums2[j] && mask[j] == false) {
                    list.add(nums1[i]);
                    mask[j] = true;
                    break;
                }
            }
        }
        ret = new int[list.size()];
        int index = 0;
        for (int tmp : list) {
            ret[index++] = tmp;
        }
        return ret;
    }

    //哈希表辅助空间
    public static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
        if (nums1.length > nums2.length) {
            intersect2(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (int j : nums2) {
            int cnt = map.getOrDefault(j, 0);
            if (cnt > 0) {
                list.add(j);
                map.put(j, cnt - 1);
            }
        }
        int[] ret = new int[list.size()];
        index = 0;
        for (int tmp : list) {
            ret[index++] = tmp;
        }
        return ret;
    }

    //可以排序  双指针
    public static int[] intersect3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i++]);
                j++;
            }
        }
        int[] ret = new int[list.size()];
        int index = 0;
        for (int tmp : list) {
            ret[index++] = tmp;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 1};
        int[] b = new int[]{2, 2, 1};
        Arrays.sort(a);
        Arrays.sort(b);
        int[] retn = intersect3(a, b);
        for (int i : retn) {
            System.out.print(i + "  ");
        }
    }
}
