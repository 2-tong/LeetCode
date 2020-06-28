package xyz.tong2.leetcode.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive_no128 {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> allNums = new HashSet<>();

        for (int n : nums)
            allNums.add(n);

        Set<Integer> pass = new HashSet<>();
        for (Integer key :
                allNums) {
            if (!pass.contains(key)&&!allNums.contains(key - 1)) {
                int count = 0;
                while (allNums.contains(key)) {
                    count ++;
                    pass.add(key);
                    key += 1;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutive_no128 solution = new LongestConsecutive_no128();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
