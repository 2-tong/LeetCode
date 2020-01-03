package xyz.tong2.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0)
            return true;
        for (String word :
                wordDict) {
            if (s.startsWith(word)) {
                if(wordBreak(s.substring(word.length()),wordDict))
                    return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] wordDict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        WordBreak soul = new WordBreak();
        System.out.println(soul.wordBreak(s, Arrays.asList(wordDict)));
    }
}
