package xyz.tong2.leetcode.recursion;

public class SubarraySum_no560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int[] sums = new int[nums.length];
        sums[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
            if(sums[i]==k)
                ans++;
        }

        for (int start = 1; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                if(sums[end]-sums[start-1]==k)
                    ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraySum_no560 solution = new SubarraySum_no560();
        int[] nums = {-1,-1,1};
        int key = 0;
        System.out.println(solution.subarraySum(nums, key));
    }
}
