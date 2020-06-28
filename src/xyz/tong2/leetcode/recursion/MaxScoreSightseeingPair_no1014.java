package xyz.tong2.leetcode.recursion;

import java.util.Map;

public class MaxScoreSightseeingPair_no1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int maxPoint = A[0];

        for (int i = 1; i < A.length; i++) {
            int source = A[i]+maxPoint-i;
            ans = Math.max(ans,source);
            maxPoint = Math.max(maxPoint,A[i]+i);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
