package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class TwoSum_no1 {
    public int[] twoSum(int[] nums, int target) {
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        int start = 0;
        int end = numsCopy.length-1;
        while (numsCopy[start]+numsCopy[end]!=target){
            if(numsCopy[start]+numsCopy[end]>target)
                end--;
            else
                start++;
        }
        int[] ans = new int[2];
        int flag = 0;
        for(int i=0;i<nums.length&&flag<2;i++){
            if(nums[i]==numsCopy[start])
                ans[flag++]=i;
            else if(nums[i]==numsCopy[end])
                ans[flag++]=i;
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoSum_no1 twoSum = new TwoSum_no1();
        int[] nums = { 11, 15,2, 7};
        int target = 9;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
