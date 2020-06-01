package xyz.tong2.leetcode.recursion;

public class FindDuplicate_no287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <nums.length-1 ; j++) {
                if(nums[i]==nums[j])
                    return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindDuplicate_no287 solution = new FindDuplicate_no287();
        int[] nums = {2,3,5,4,8,4,6,7,9};
        System.out.println(solution.findDuplicate(nums));
    }
}
