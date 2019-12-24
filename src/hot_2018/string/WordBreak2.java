package hot_2018.string;

import java.util.*;

/**
 * 单词拆分
 */
public class WordBreak2 {
    //超时
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s,wordDict,0);
    }

    private static List<String> wordBreak(String s, List<String> wordDict, int start) {
        List<String> res = new LinkedList<>();
        if (start == s.length()){
            res.add("");
        }
        for (int end = start+1; end <= s.length() ; end++) {
            if (wordDict.contains(s.substring(start,end))){
                List<String> list = wordBreak(s, wordDict, end);
                for (String l: list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        return res;
    }

    // 记忆化回溯  DFS
    //map 存储以i开始的所有子串
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak2(String s, Set<String> wordDict) {
        return word_Break2(s, new HashSet<>(wordDict), 0);
    }

    public List<String> word_Break2(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break2(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    // 也是 map key不一样
    public List<String> wordBreak2(String s, List<String> wordDict) {
        return backtrack(s,wordDict,new HashMap<String, List<String>>());
    }
    // backtrack returns an array including all substrings derived from s.
    public List<String> backtrack(String s, List<String> wordDict, Map<String,List<String>> mem){
        if(mem.containsKey(s))
            return mem.get(s);
        List<String> result = new ArrayList<String>();
        for(String word: wordDict) {
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                if (next.length() == 0)
                    result.add(word);
                else
                    for (String sub : backtrack(next, wordDict, mem))
                        result.add(word + " " + sub);
            }
        }
        mem.put(s, result);
        return result;
    }

    //dp 超时了  存储String耗时
    public static List<String> wordBreak3(String s, Set<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }



    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<>();
        wordDict.add("cats");
        wordDict.add("nd");
        wordDict.add("dog");
        wordDict.add("cat");
        wordDict.add("snd");
        List<String> list = new WordBreak2().wordBreak3("catsnddog", wordDict);
        System.out.println(list.size());
    }

}
