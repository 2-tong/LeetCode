package xyz.tong2.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum_no15 {
    List<List<Integer>> ans;
    int lastA = -1;
    int lastB = -1;
    int lastC = -1;
    private void addAnswer(int a,int b,int c){
        if(a!=lastA||b!=lastB||c!=lastC) {
            lastA=a;
            lastB=b;
            lastC=c;

            List<Integer> list = new ArrayList<>(3);
            list.add(a);
            list.add(b);
            list.add(c);
            ans.add(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ans = new LinkedList<>();
        if(nums.length<3)
            return ans;

        Arrays.sort(nums);

        if(nums[0]>=0) {
            if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0)
                addAnswer(0, 0, 0);
            return ans;
        }

        if(nums[nums.length-1]<=0){
            if(nums[nums.length-1]==0&&nums[nums.length-2]==0&&nums[nums.length-3]==0)
                addAnswer(0,0,0);
            return ans;
        }

        for (int i = 0;nums[i]<=0;i++) {
            if(i>1&&nums[i]==nums[i-1])
                continue;
            int bIndex = i+1;
            int cIndex = nums.length-1;
            while (bIndex<cIndex){
                if(nums[i]+nums[bIndex]+nums[cIndex]==0) {
                    addAnswer(nums[i], nums[bIndex], nums[cIndex]);
                    bIndex++;
                    cIndex--;
                }
                else if(Math.abs(nums[i])>nums[bIndex]+nums[cIndex])
                    bIndex++;
                else
                    cIndex--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,-4,-5,3,1,3,4,2,-5,2,4,2,-5};
        ThreeSum_no15 solution = new ThreeSum_no15();
        System.out.println(solution.threeSum(nums));
    }
}
