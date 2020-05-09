package xyz.tong2.leetcode.recursion;

public class Trap_no42 {
    public int trap(int[] height) {
        if(height==null||height.length<3)
            return 0;
        int maxIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if(height[i]>height[maxIndex])
                maxIndex=i;
        }

        int area = 0;

        int left = 0,right = height.length-1;

        int max=height[left];

        while (left<maxIndex){
            if(height[left]>max)
                max=height[left];
            else
                area+=(max-height[left]);
            left++;
        }
        max = height[right];
        while (right>maxIndex){
            if(height[right]>max)
                max=height[right];
            else
                area+=(max-height[right]);
            right--;
        }

        return area;
    }

    public static void main(String[] args) {
        Trap_no42 solution = new Trap_no42();
        int[] nums = {1,2,3,4,5,6,5,4,3,2,1};
        System.out.println(solution.trap(nums));
    }
}
