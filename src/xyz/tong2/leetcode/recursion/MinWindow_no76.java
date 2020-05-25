package xyz.tong2.leetcode.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindow_no76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countLine = new HashMap<>();
        Map<Character, Integer> charCount = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (char c : t.toCharArray()) {
            Integer count = countLine.get(c);
            count = count==null?1:count+1;
            countLine.put(c,count);
            charCount.put(c,0);
            set.add(c);
        }
        int ansS=-1,ansE=-1,start=0,end = 0;
        while (start<s.length()&&end<=s.length()){
            if(!countLine.containsKey(s.charAt(start)))
                start++;
            else if(charCount.get(s.charAt(start))>countLine.get(s.charAt(start))){
                charCount.put(s.charAt(start),charCount.get(s.charAt(start))-1);
                start++;
            }
            else if(end<s.length()){
                if(set.isEmpty()&&(end-start<ansE-ansS||ansS==-1)){
                    ansS=start;
                    ansE=end;
                }
                if(end<start)
                    end=start;
                char key = s.charAt(end);
                if(countLine.containsKey(key)){
                    int count = charCount.get(key)+1;
                    int line = countLine.get(key);
                    if(count==line)
                        set.remove(key);
                    charCount.put(key,count);
                }
                end++;

            }
            else
                break;
        }
        if(set.isEmpty()&&(end-start<=ansE-ansS||ansS==-1)){
            ansS=start;
            ansE=end;
        }
        if(ansS==-1)
            return "";

        return s.substring(ansS, ansE);
    }

    public static void main(String[] args) {
        MinWindow_no76 solution = new MinWindow_no76();
        String s = "a";
        String t = "b";
        System.out.println(solution.minWindow(s, t));
    }
}
