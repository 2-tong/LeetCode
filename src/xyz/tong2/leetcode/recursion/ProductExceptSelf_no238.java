package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class ProductExceptSelf_no238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0]=nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            ans[i]=nums[i]*ans[i-1];
        }
        int product = nums[nums.length-1];
        ans[nums.length-1]=ans[nums.length-2];
        for (int i=nums.length-2;i>0;i--){
            int a = product;
            product*=nums[i];
            ans[i]=ans[i-1]*a;
        }
        ans[0]=product;

        return ans;
    }

    public static void main(String[] args) {
        ProductExceptSelf_no238 solution = new ProductExceptSelf_no238();
        int[] nums = {4,3,2,1,2};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }
}
