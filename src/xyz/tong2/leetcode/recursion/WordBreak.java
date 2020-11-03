package xyz.tong2.leetcode.recursion;

import java.util.*;

public class WordBreak {
    Map<String,Boolean> dp = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0)
            return true;

        if(dp.containsKey(s))
            return dp.get(s);

        boolean ans = false;

        for (String word :
                wordDict) {
            if (s.startsWith(word)) {
                if(wordBreak(s.substring(word.length()),wordDict))
                    ans = true;
            }
        }
        dp.put(s,ans);
        return ans;
    }


    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] wordDict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        WordBreak soul = new WordBreak();
        System.out.println(soul.wordBreak(s, Arrays.asList(wordDict)));
    }
}
