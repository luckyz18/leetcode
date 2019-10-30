package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class num_5 {

    /**
     * 似乎特别慢  发生未知错误  没过
     *
     * @param s
     * @return
     */
    public static String longestPalindrome4(String s) {
        List<String> list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i) + "");
        }

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == target) {  //这有有相同的才停下来判断这俩之间的是否符合回文
                    boolean isHui = isHuiwen(s, i, j);
                    if (isHui) {
                        list.add(s.substring(i, j + 1));
                    }
                }
            }
        }

        if (list != null && list.size() > 0) {
            int size = 0;
            String maxString = "";
            for (int i = 0; i < list.size(); i++) {
                maxString = (size > list.get(i).length() ? maxString : list.get(i));
                size = Math.max(size, list.get(i).length());
            }
            return maxString;
        }
        return "";
    }

    public static boolean isHuiwen(String s, int left, int right) {
        StringBuffer sb = new StringBuffer();
        String substring = s.substring(left, right + 1);
        sb.append(substring);
        String s1 = sb.reverse().toString();
        return (s1.equals(substring));
    }


    /**
     * 1. 别人的解法 比较好的
     * 中心扩展的思想
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        /*保存起始位置，测试了用数组似乎能比全局变量稍快一点*/
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            /*把回文看成中间的部分全是同一字符，左右部分相对称
            找到下一个与当前字符不同的字符*/
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        /* 查找中间部分*/
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        /*定位中间部分的最后一个字符*/
        int ans = high;
        /*从中间向左右扩散*/
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        /*记录最大长度*/
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    /**
     * 2. 暴力解法
     * 提交时超时
     */
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public static String longestPalindrome3(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if ( j-i > max && isPalindromic(test)) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    /**
     * 3. 动态规划  改进暴力（在验证时是否是回文字符串时减少不必要的计算）
     */
    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j == i + 1 && s.charAt(j) == s.charAt(i)) {
                    dp[i][j] = true;
                } else if (j > i + 1 && (dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j))) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        int maxLen = 0;
        String maxStr = "";
        for (int i = 0; i <s.length() ; i++) {
            for (int j = s.length()-1; j>=0 ; j--) {
                if (dp[i][j] == true && (j-i+1)>maxLen){
                    maxLen = j-i+1;
                    maxStr = s.substring(i,j+1);
                    break;
                }
            }
        }
        return maxStr;
    }

    /**
     * 4. 网上  中心扩展法  由每一个字母为中心  向外扩展两边的得对称
     * 中心可能是 两个字母  所以还要以 i i+1 为中心往外扩展
     */

    public static String longestPalindrome5(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
                if (len > end - start +1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        String a = "afgf";
        String babad = longestPalindrome2(a);
        System.out.println(babad);
    }

}


