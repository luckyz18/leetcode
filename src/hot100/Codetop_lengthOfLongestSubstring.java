package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 */
public class Codetop_lengthOfLongestSubstring {

    public  static  int lengthOfLongestSubstring(String s) {
        Set<String> set = new HashSet<>();
        int length = s.length();
        int start = 0;
        int maxLen = 0;
        int end = start;
        for (; end <length ; end++) {
            char c = s.charAt(end);
            if (set.contains(String.valueOf(c))){
                maxLen = Math.max(maxLen, end - start);
                set.clear();
                start = end;
            } else {
                set.add(String.valueOf(c));
            }
        }
        return maxLen;
    }

    public static  int lengthOfLonestSubString2(String  s){
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
                //left = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int len = lengthOfLonestSubString2("abba");
        System.out.println(len);
    }

}
