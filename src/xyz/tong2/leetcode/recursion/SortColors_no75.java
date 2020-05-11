package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class SortColors_no75 {
    public void sortColors(int[] nums) {
        int posOne=nums.length-1;
        int posTwo=posOne;
        int left=nums.length;
        int current=0;
        while (left>0){
            if(nums[current]==0)
                current++;
            else if(nums[current]==1){
                nums[current]=nums[posOne];
                nums[posOne]=1;
                posOne--;
            }
            else {
                nums[current]=nums[posOne];
                nums[posOne]=1;
                nums[posTwo]=2;
                posOne--;
                posTwo--;
            }
            left--;
        }
    }

    public static void main(String[] args) {
        SortColors_no75 solution = new SortColors_no75();
        int[] arr = new int[]{2, 1, 0, 2, 1, 2, 2, 2, 1, 1};
        solution.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
