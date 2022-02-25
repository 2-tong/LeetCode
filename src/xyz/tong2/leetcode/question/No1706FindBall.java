package xyz.tong2.leetcode.question;

/**
 * TODO
 *
 * @author liwei04
 * @time 2022年02月24日 14:33
 */
public class No1706FindBall {
    public int[] findBall(int[][] grid) {
        int[] ball = new int[grid[0].length];
        for (int i = 0; i < ball.length; i++) ball[i] = i;
        for (int[] board : grid) {
            for (int i = 0; i < ball.length; i++) {
                if(ball[i]==-1)
                    continue;
                int pos = ball[i]+board[ball[i]];
                if(pos<0||pos==ball.length||board[ball[i]]!=board[pos])
                    ball[i]=-1;
                else
                    ball[i]=pos;
            }
        }
        return ball;
    }
}
