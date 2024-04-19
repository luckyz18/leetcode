package hot100;

import java.util.*;

/**
 * 字母异位词分组
 */
public class Code_2_groupAnaGrams {


    public static  List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0 ){
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(strs[i]);
            map.put(sortedStr,list );
        }
        List<List<String>> values = new ArrayList<>(map.values());
        return values;
    }

    public static void main(String[] args) {
        //String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = new String[] {"",""};
        groupAnagrams(strs);
        System.out.println();
    }

}
