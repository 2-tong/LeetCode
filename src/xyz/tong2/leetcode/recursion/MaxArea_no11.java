package xyz.tong2.leetcode.recursion;

import java.util.*;

public class MaxArea_no11 {
    public int maxArea(int[] height) {
        int start=0;
        int end = height.length-1;
        int ans = 0;
        while (start<end)
        {
            ans = Math.max((end-start)*Math.min(height[start],height[end]),ans);
            if(height[start]<height[end])
                start++;
            else
                end--;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxArea_no11 solution = new MaxArea_no11();
    }
}
