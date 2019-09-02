package xyz._2tong.leetcode.soul;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int[] count = new int[32];
        for(int i=0;i<nums.length;i++) {

            for (int j = 0; j < 32; j++) {
                count[j]+=((nums[i]>>j)&1);
            }
        }
        int res=0;
        for (int j = 0; j < 32; j++) {
            if(count[j]>(nums.length/2))
                res=res|(1<<j);
        }
        return res;
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int ns[] = {7,3,15,3,15,8,15,15,15,56,15,78,15};
        System.out.println(m.majorityElement(ns));
    }
}
