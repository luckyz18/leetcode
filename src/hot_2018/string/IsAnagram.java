package hot_2018.string;

/**
 * 字母异位词
 */
public class IsAnagram {
    public static boolean isAnagram(String s,String t){
        if (s == null || t ==null)
            return false;
        if ( s.length() ==0 && t.length() == 0){
            return true;
        }
        int sLen = s.length();
        int tLen = t.length();
        if (sLen!= tLen) return false;
        int[] times = new int[26];
        for (int i = 0; i <sLen ; i++) {
            char c= s.charAt(i);
            times[c-'a']++;
        }
        for (int i = 0; i <tLen ; i++) {
            char c = t.charAt(i);
            times[c-'a']--;
        }
        for (int i = 0; i < 26 ; i++) {
            if (times[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean a = isAnagram("rat", "");
        System.out.println(a);
    }
}
