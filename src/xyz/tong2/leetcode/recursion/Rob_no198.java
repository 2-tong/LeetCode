package xyz.tong2.leetcode.recursion;

public class Rob_no198 {
    public int rob(int[] nums) {
        if(nums.length<2)
            return nums.length==0?0:nums[0];
        int[] arrays =new int[nums.length];
        arrays[0]=nums[0];
        arrays[1]=Math.max(arrays[0],nums[1]);
        for (int i = 2; i <nums.length ; i++)
            nums[i]=Math.max(nums[i-1],nums[i]+nums[i-2]);
        return nums[nums.length-1];
    }
}
