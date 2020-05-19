package xyz.tong2.leetcode.recursion;

public class MaxProduct_no152 {
    public int maxProduct(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int index = 0;

        while (index<nums.length&&nums[index]==0)
            index++;
        if(index==nums.length)
            return 0;

        int len=0;
        int max = nums[0];
        int pre = 1;

        int preSum = 1;
        int endSum = 1;

        while (index<=nums.length){
            if(index==nums.length||nums[index]==0) {
                if(pre>0||len==1)
                    max=Math.max(max,pre);
                else {
                    max=Math.max(max,Math.max(pre/preSum,pre/endSum));
                }
                index++;
                while (index<nums.length&&nums[index]==0)
                    index++;
                if(index==nums.length)
                    break;
                len=0;
                pre = preSum = endSum = 1;
            }
            else{
                pre*=nums[index];
                if(preSum>0)
                    preSum*=nums[index];
                endSum*=nums[index];
                if(nums[index]<0)
                    endSum=nums[index];
                index++;
                len++;
            }
        }
        return Math.max(0,max);
    }
    public int maxProduct2(int[] nums){
        int start = 0,end;
        int ans = nums[0];
        while (start<nums.length){
            while (start<nums.length&&nums[start]==0)
                start++;
            end=start;
            if(start==nums.length)
                break;
            int product = 1;
            int negativeStart =1,negativeEnd= 1;
            while (end<nums.length&&nums[end]!=0){
                if(negativeStart>0)
                    negativeStart*=nums[end];
                negativeEnd*=nums[end];
                if(nums[end]<0)
                    negativeEnd=nums[end];
                product*=nums[end++];
            }
            if(end-start==1||product>0)
                ans=Math.max(ans,product);
            else
                ans=Math.max(ans,Math.max(product/negativeEnd,product/negativeStart));
            start=end;
        }
        return nums.length==1?ans:Math.max(0,ans);
    }


    public static void main(String[] args) {
        MaxProduct_no152 solution = new MaxProduct_no152();
        int[] nums = {-2};
        System.out.println(solution.maxProduct2(nums));
    }
}
