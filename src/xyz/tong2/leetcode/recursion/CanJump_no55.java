package xyz.tong2.leetcode.recursion;


/**
 * No.55
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * LeetCode
 * */
public class CanJump_no55 {
    public boolean canJump(int[] nums) {

        //记录最远的能到达的步数
        int maxStep = 0;
        for (int i = 0; i < nums.length-1;i++) {

            //如果当前位置的值为0且目前最远距离不大于i则永远不能跨过i
            if(nums[i]==0&&maxStep<=i)
                    return false;
            else {
                //更新最大步数
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
