package hot_2018.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 */
public class Partition {

    List<List<String>> resultLst;
    ArrayList<String> currLst;

    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s, 0);
        return resultLst;
    }

    public void backTrack(String s, int l) {
        if (currLst.size() > 0 //the initial str could be palindrome
                && l >= s.length()) {
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
        }
        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s, l, i)) {
                if (l == i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l, i + 1));
                backTrack(s, i + 1);
                currLst.remove(currLst.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r) {
        if (l == r) return true;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    //2. !!!
    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        dfs(s, 0, list, res);
        return res;
    }

    public void dfs(String s, int pos, List<String> list, List<List<String>> res) {
        if (pos == s.length())
            res.add(new ArrayList<>(list));
        else {
            for (int i = pos; i < s.length(); i++) {
                if (isPal2(s, pos, i)) {
                    list.add(s.substring(pos, i + 1));
                    dfs(s, i + 1, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public boolean isPal2(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        return true;
    }

    //3. DP
    public static List<List<String>> partitionWithDP(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        partitionWithDPCore(s, dp, 0, res, new ArrayList<String>());
        return res;
    }

    private static void partitionWithDPCore(String s, boolean[][] dp, int pos, List<List<String>> res, ArrayList<String> list) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = pos; i < s.length(); i++) {
                if (dp[pos][i]) {
                    list.add(s.substring(pos, i + 1));
                    partitionWithDPCore(s, dp, i + 1, res, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> result = partitionWithDP("leetcode");
        System.out.println();
    }
}
