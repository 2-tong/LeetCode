package xyz.tong2.leetcode.recursion;

public class Search_no33 {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid = (start+end)/2;
        while (start <=end) {
            if (nums[mid] == target)
                return mid;
            else if(nums[start] == target)
                return start;
            else if(nums[end] == target)
                return end;
            else{
                if(start==mid)
                    return -1;
                if(nums[mid]<nums[end]){
                    if(target<nums[end]&&target>(nums[mid]))
                        start=mid;
                    else
                        end=mid;
                }
                else {
                    if(target<nums[mid]&&target>(nums[start]))
                        end=mid;
                    else
                        start=mid;
                }
            }

            mid = (start + end) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums ={4,5,6,7,8,1,2,3};
        int key = 8;
        Search_no33 solution = new Search_no33();
        System.out.println(solution.search(nums, key));
    }
}
