package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class MinPathSum_no64 {
    int[][] grid;
    int[][] dp;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        dp = new int[grid.length][grid[0].length];

        for (int[] array :
                dp) {
            Arrays.fill(array, -1);
        }

        return process(grid.length - 1, grid[0].length - 1);
    }

    int process(int row, int col) {
        if (row == 0 && col == 0)
            return grid[row][col];
        if (dp[row][col] == -1) {
            if (row == 0)
                dp[row][col] = process(row, col - 1) + grid[row][col];
            else if (col == 0)
                dp[row][col] = process(row - 1, col) + grid[row][col];
            else
                dp[row][col] = Math.min(process(row - 1, col), process(row , col-1)) + grid[row][col];
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        MinPathSum_no64 solution = new MinPathSum_no64();
        int[][] map = {
                {1}};

        System.out.println(solution.minPathSum(map));
    }
}
