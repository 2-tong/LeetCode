package xyz.tong2.leetcode.recursion;

public class LengthOfLongestSubstring_no3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        if (s.length() < 2)
            return s.length();
        int[] countArray = new int[256];
        char[] str = s.toCharArray();
        int start = 0;
        int end = 1;
        int max = 1;
        countArray[str[start]]++;
        while (end < s.length()) {
            countArray[str[end]]++;

            if (countArray[str[end]] < 2) {
                max = Math.max(max, end - start + 1);
            }
            else {
                while (countArray[str[end]] > 1) {
                    countArray[str[start]]--;
                    start++;
                }
            }
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_no3 length = new LengthOfLongestSubstring_no3();
        System.out.println(length.lengthOfLongestSubstring("dvdf"));
    }
}
