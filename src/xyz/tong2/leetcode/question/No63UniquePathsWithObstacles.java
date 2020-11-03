package xyz.tong2.leetcode.question;

import java.util.Arrays;

public class No63UniquePathsWithObstacles {
    int ans = 0;
    int[][] obstacleGrid;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0||obstacleGrid[0].length==0||obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)
            return 0;
        this.obstacleGrid = obstacleGrid;
        dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        return process(0,0);
    }

    int process(int row,int col){
        if(dp[row][col]!=0)
            return dp[row][col];
        int ans = 0;
        if(obstacleGrid[row][col]==1)
            return 0;
        if(row==obstacleGrid.length-1&&col==obstacleGrid[0].length-1)
            return 1;
        else {
            if(row<obstacleGrid.length-1)
                ans+=process(row+1,col);
            if(col<obstacleGrid[0].length-1)
                ans+=process(row,col+1);
        }
        dp[row][col]=ans;
        return ans;
    }
}
