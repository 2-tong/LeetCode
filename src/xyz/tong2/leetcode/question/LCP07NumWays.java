package xyz.tong2.leetcode.question;

import java.util.Arrays;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年07月02日 16:06
 */
public class LCP07NumWays {
    int[][] dp;

    public int numWays(int n, int[][] relation, int k) {
        int[][] map = new int[n][n];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], -1);
        }
        int[] size = new int[n];
        Arrays.fill(size,0);
        for (int[] r:relation) {
            map[r[0]][size[r[0]]++]=r[1];
        }
        dp = new int[n][k];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        Arrays.fill(dp,-1);
        return process(map,0,k);
    }

    private int process(int[][] map,int pos,int k){
        if(k == 0){
            return pos == map.length-1?1:0;
        }
        if(dp[pos][k]!=-1){
            return dp[pos][k];
        }
        int result = 0;
        int index = 0;
        while (map[pos][index]!=-1){
            result += process(map,map[pos][index],k-1);
            index++;
        }
        dp[pos][k] = result;
        return result;
    }
}
