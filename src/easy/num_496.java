package easy;

import java.util.*;

public class num_496 {
    static Map<Integer, Integer> map = new LinkedHashMap();
    static Map<Integer, Integer> map2 = new LinkedHashMap();
    static List resList = new ArrayList();

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len2; i++) {
            map.put(i, nums2[i]);
            map2.put(nums2[i], i);
        }
        boolean f;
        for (int i = 0; i < len1; i++) {
            f = true;
            int compareNum = nums1[i];
            int coordinate = map2.get(compareNum);
            for (int j = coordinate +1; j < len2; j++) {
                if (map.get(j) > compareNum) {
                    resList.add(map.get(j));
                    f= false;
                    break;
                }
            }
            if (f == true){
                resList.add(-1);
            }

        }
        int[] resArr = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = (int) resList.get(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
        int num1[] = {2,4};
        int num2[] = {1, 2, 3, 4};
        int[] ints = nextGreaterElement(num1, num2);
        System.out.println(ints.toString());

    }
}
