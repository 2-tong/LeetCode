package xyz.tong2.leetcode.question;

import java.util.Arrays;

public class No283MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length<2)
            return;
        int index = 0;
        int zCount = 0;
        for (int i = 0; i<nums.length;i++){
            if(nums[i]==0)
                zCount++;
            else
                nums[index++]=nums[i];
        }
        for (int i = nums.length-zCount;i<nums.length;i++)
            nums[i]=0;
    }
}
