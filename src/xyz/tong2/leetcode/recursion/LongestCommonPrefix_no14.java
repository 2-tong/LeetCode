package xyz.tong2.leetcode.recursion;

public class LongestCommonPrefix_no14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1)
            return "";
        StringBuilder ans = new StringBuilder();
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            int j = 1;
            for (; j < strs.length; j++) {
                if (i>=strs[j].length()||strs[j].charAt(i) != c)
                    break;
            }
            if (j != strs.length)
                break;
            ans.append(c);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        LongestCommonPrefix_no14 solution = new LongestCommonPrefix_no14();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
