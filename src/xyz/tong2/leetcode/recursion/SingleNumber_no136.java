package xyz.tong2.leetcode.recursion;


public class SingleNumber_no136 {
    public int singleNumber(int[] nums) {
        for (int i =1; i < nums.length; i++) {
            nums[0]=nums[0]^nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        SingleNumber_no136 solution = new SingleNumber_no136();
        int [] ns = {8,3,8,2,2,4,67,3,4};
        System.out.println(solution.singleNumber(ns));
    }
}
