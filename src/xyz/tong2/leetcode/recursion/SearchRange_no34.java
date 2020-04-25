package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class SearchRange_no34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0,end=nums.length-1;
        int[] ans = new int[2];

        int key1=-1;
        int key2=-1;
        while (start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    key1 = mid;
                    break;
                }
                else
                    end=mid-1;
            }
            else {
                if(nums[mid]>target)
                    end=mid-1;
                else
                    start=mid+1;
            }
        }
        if(key1!=-1) {
            start = 0;
            end=nums.length-1;

            while (start <= end) {
                int mid = (start+end)/2;
                if (nums[mid] == target) {
                    if (mid == nums.length-1 || nums[mid + 1] != target) {
                        key2 = mid;
                        break;
                    }
                    else
                        start = mid + 1;
                } else {
                    if (nums[mid] > target)
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
        }

        ans[0]=key1;
        ans[1]=key2;
        return ans;
    }

    public static void main(String[] args) {
        SearchRange_no34 solution = new SearchRange_no34();
        int[] nums = {};
        System.out.println(Arrays.toString(solution.searchRange(nums,1)));
    }
}
