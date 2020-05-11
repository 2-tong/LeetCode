package xyz.tong2.leetcode.recursion;

import java.util.*;

public class GroupAnagrams_no49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str:
             strs) {
            String key = getKey(str);
            if(map.containsKey(key))
                map.get(key).add(str);
            else {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(key,list);
            }
        }
        List<List<String>> ans = new LinkedList<>();

        for (String key:
             map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    private String getKey(String str){
        int[] count=new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)-'a']++;
        }
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(String.valueOf((char) ('a' + i)).repeat(Math.max(0, count[i])));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams_no49 solution = new GroupAnagrams_no49();
        System.out.println(solution.groupAnagrams(strings));
    }
}
