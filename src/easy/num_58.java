package easy;

/**
 * 最后一个单词的长度
 */
public class num_58 {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        String[] splitString = s.split(" ");
        if (splitString.length > 0 && !"".equals(splitString[splitString.length-1])){
            String res = splitString[splitString.length-1];
            return res.length();
        }else{
            return 0;
        }
    }

    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        int start = s.lastIndexOf(" ") + 1;
        return s.substring(start).length();
    }

    public static int lengthOfLastWord3(String s) {
        s = s.trim();
        int start = s.lastIndexOf(" ") + 1;
        int end = s.length()-1;
        return end - start + 1;
    }




    public static void main(String[] args) {
        int i  =lengthOfLastWord3("  f   po  ");
        System.out.println(i);
    }
}
