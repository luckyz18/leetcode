package easy;

/**
 * 最长公共前缀
 */
public class num_14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        String res = "";
        int min_len = minLen(strs);
        for (int i = 0; i < min_len; i++) {
            char c = strs[0].charAt(i);
            for (String s:strs) {
                if (s.equals(strs[0])){
                    continue;
                }
                if (c!=s.charAt(i)){
                    return res;
                }
            }
            res += c;
        }
        return res;
    }

    public static  int minLen(String [] str){
        if (str.length > 0){
            int res = str[0].length();
            for (String s: str) {
                res = s.length() > res ? res: s.length();
            }
            return res;
        }
        return 0;
    }

    //2. 水平扫描 官方解法
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0) {    //str.indexof(子串) 返回包含该子串的第一个字母的下标
                System.out.println(strs[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 3. 水平扫描
    public static String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i <strs[0].length() ; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j <strs.length ; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,strs[0].length()-1);
    }

    //4. 分治
    public static String longestCommonPrefix4(String[] strs) {
        if (strs.length == 0) return "";
        return longestCommonPrefix4(strs,0,strs.length-1);
    }

    private static String longestCommonPrefix4(String[] strs, int left, int right) {
        if (left == right){
            return strs[left];
        }
        int mid = (left + right) /2 ;
        String leftCommon  = longestCommonPrefix4(strs,0,mid);
        String rightCommon = longestCommonPrefix4(strs,mid+1,right);
        return leftAndRightCommon(leftCommon,rightCommon);
    }

    private static String leftAndRightCommon(String leftCommon, String rightCommon) {
        int minLen = leftCommon.length()<rightCommon.length()
                        ?leftCommon.length()
                        :rightCommon.length();
        for (int i = 0; i <minLen ; i++) {
            if (leftCommon.charAt(i) != rightCommon.charAt(i)){
                return leftCommon.substring(0,i);
            }
        }
        return leftCommon.substring(0,minLen);
    }


    public static void main(String[] args) {
        String s = longestCommonPrefix4(new String[]{"flower", "flow", "flowght"});
        System.out.println(s);


    }
}
