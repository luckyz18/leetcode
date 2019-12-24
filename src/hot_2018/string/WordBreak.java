package hot_2018.string;

import java.util.*;

/**
 * 单词拆分
 */
//超时    对于 aaaaaaaaaaaaaa这种情形
public class WordBreak {
    public static boolean wordBreak5(String s, List<String> wordDict) {
        return wordBreak5(s, new HashSet(wordDict), 0);
    }

    private static boolean wordBreak5(String s, HashSet set, int start) {
        if (start == s.length()) {
            return true;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end)) && wordBreak5(s, set, end)) {
                return true;
            }
        }
        return false;
    }

    //2. ac 记忆化回溯
    public static boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreak2(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }

    private static boolean wordBreak2(String s, HashSet<String> set, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        // !!!
        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end)) && wordBreak2(s, set, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }

    //3. BFS
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }


    //4. dp
    //以 0-i 结尾的字符串能不能被字典分割
    public static boolean wordBreak4(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //5.
    //leetcode解法
    public boolean wordBreak5(String s, Set<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        //list.add("sand");
        //list.add("and");
        //list.add("cat");
        boolean aBreak = wordBreak4("leetcode", list);
        System.out.println(aBreak);
    }


}
