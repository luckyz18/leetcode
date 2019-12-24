package hot_2018.string;

import java.util.Arrays;

/**
 * 字符串中第一个只出现一次的字符
 */
public class FirstUniqueChar {
    public static int firstUniqueChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] times = new int[26];
        Arrays.fill(times, 0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (times[c - 'a'] == 0) {
                times[c - 'a'] = 1;
            } else {
                times[c - 'a']++;
            }
        }
        int index = 0;
        while (index < s.length() && times[s.charAt(index) - 'a'] != 1) {
            index++;
            continue;
        }
        if (index < s.length()) {
            return index;
        }

        return -1;
    }

    public static void main(String[] args) {
        int k = firstUniqueChar("cc");
        System.out.println(k);
    }

}
