package xyz.tong2.leetcode.recursion;

public class FirstMissingPositive_no41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len;i++) {
            if(nums[i]==0)
                nums[i]=-1;
        }
        for (int i = 0; i < len;) {
            if(nums[i]>0&&nums[i]<=len){
                int swap = nums[nums[i]-1];
                nums[nums[i]-1] = 0;
                nums[i]=swap;
            }
            else
                i++;
        }

        for (int i = 0; i < len; i++) {
            if(nums[i]!=0)
                return i+1;
        }
        return len+1;
    }
}
