package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class NextPermutation_no31 {

    int[] numArray = null;

    private void changeNums(int indexA,int indexB){
        int tmp = numArray[indexA];
        numArray[indexA] = numArray[indexB];
        numArray[indexB] = tmp;
    }

    private void revertNums(int begin){
        if(begin<numArray.length-1){
            int end = numArray.length-1;
            while (begin<end){
                changeNums(begin++,end--);
            }
        }
    }

    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<2)
            return;
        numArray = nums;
        int min = nums.length-1;
        for (int i = nums.length-2; i >=0 ; i--) {
            if(nums[i]<nums[i+1]){
                while (nums[min]<=nums[i])
                    min--;
                changeNums(i,min);
                revertNums(i+1);
                return;
            }
        }
        revertNums(0);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        NextPermutation_no31 solution = new NextPermutation_no31();
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
