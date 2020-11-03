package xyz.tong2.leetcode.recursion;

public class MinSubArrayLen_no209 {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0,end = 0,sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end<=nums.length){
            if(sum<s) {
                if(end==nums.length)
                    break;
                sum+=nums[end];
                end++;
            }
            else {
                ans = Math.min(end-start,ans);
                sum-=nums[start];
                start++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    public static void main(String[] args) {
        MinSubArrayLen_no209 solution = new MinSubArrayLen_no209();
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        System.out.println(solution.minSubArrayLen(s, nums));
    }
}
