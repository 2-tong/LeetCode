package xyz._2tong.leetcode.soul;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        int [] ns = {8,3,8,2,2,4,67,3,4};
        System.out.println(s.singleNumber(ns));
    }
}
