package xyz.tong2.leetcode.recursion;

public class CanJump_no55 {
    public boolean canJump(int[] nums) {
        int maxStep = 0;
        for (int i = 0; i < nums.length-1;i++) {
            if(nums[i]==0)
            {
                if(maxStep<=i)
                    return false;
            }
            else {
                maxStep = Math.max(maxStep, nums[i] + i);
                if (maxStep >= nums.length - 1)
                    return true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        CanJump_no55 solution = new CanJump_no55();
        int[] steps = {0};
        System.out.println(solution.canJump(steps));
    }
}
