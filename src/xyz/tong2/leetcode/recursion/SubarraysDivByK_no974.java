package xyz.tong2.leetcode.recursion;

public class SubarraysDivByK_no974 {
    public int subarraysDivByK(int[] A, int K) {
        int[] remainders = new int[2*K-1];
        int sum = 0,count = 0;
        for (int value : A) {
            sum += value;
            int rmd = sum % K,index1 = rmd+K-1,index2 = (rmd<0?K + rmd: -K + rmd)+K-1;
            remainders[index1] += 1;
            count += remainders[index1];
            if(rmd!=0) {
                count+=remainders[index2];
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraysDivByK_no974 solution = new SubarraysDivByK_no974();
        int[] array = {-2,-3,0};
        int K = 5;
        System.out.println(solution.subarraysDivByK(array, K));
    }
}
