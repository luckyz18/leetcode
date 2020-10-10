package easy;
/*实现 strStr()*/
public class num_28 {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }
        if (haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
