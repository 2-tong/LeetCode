package xyz.tong2.leetcode.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstring_no1371 {
    public int findTheLongestSubstring(String s) {
        int[] buffer = new int[1<<5];
        int ans = 0;
        int status = 0;
        Arrays.fill(buffer,-1);
        buffer[0]=0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    status ^= 1;
                    break;
                case 'e':
                    status ^= 2;
                    break;
                case 'i':
                    status ^= 4;
                    break;
                case 'o':
                    status ^= 8;
                    break;
                case 'u':
                    status ^= 16;
                    break;
            }
            if (buffer[status] >= 0)
                ans=Math.max(ans, i - buffer[status] + 1);
            else
                buffer[status] = 1 + i;
        }
        return ans;
    }


    public static void main(String[] args) {
        FindTheLongestSubstring_no1371 solution = new FindTheLongestSubstring_no1371();
        System.out.println(solution.findTheLongestSubstring("leetcodeisgreat"));
    }
}
