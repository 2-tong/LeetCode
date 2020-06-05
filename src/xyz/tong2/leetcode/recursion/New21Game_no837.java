package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class New21Game_no837 {

    private Double[] dp;

    private int range;
    private int line;
    private int checkLine;
    public double new21Game(int N, int K, int W) {
        dp = new Double[K];
        range=W;
        line=K;
        checkLine=N;

        return process(0);
    }

    private double process(int sum){
        if(sum>=line)
            return sum<=checkLine?1.0:0.0;
        else {
            if(dp[sum]!=null)
                return dp[sum];
            double p = 0.0;
            for (int i = 1; i <= range; i++)
                p+=process(sum+i);

            dp[sum]=p/range;
            return dp[sum];
        }
    }

    public double new21Game1(int N, int K, int W) {
        int[][] dp = new int[K][];
        

        return process(0);
    }

    public static void main(String[] args) {
        New21Game_no837 solution = new New21Game_no837();
        System.out.println(solution.new21Game(21,17,10));
    }
}
