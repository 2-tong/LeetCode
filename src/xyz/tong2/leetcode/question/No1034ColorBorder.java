package xyz.tong2.leetcode.question;

/**
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 *
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 *
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 *
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 *
 *
 * @author liwei04
 * @time 2021年12月07日 09:59
 */
public class No1034ColorBorder {
    private int[][] GRID;
    private int COLOR;
    private int NEW_COLOR;
    private Boolean[][] CheckMap;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        CheckMap = new Boolean[grid.length][grid[0].length];
        this.NEW_COLOR=color;
        this.GRID = grid;
        this.COLOR = grid[row][col];
        isConnectBorder(row, col);
        return grid;
    }

    private boolean isConnectBorder(int row, int col){
        if(row<0||row>= GRID.length||col<0||col>= GRID[0].length)
            return false;
        if(CheckMap[row][col]!=null)
            return CheckMap[row][col];
        CheckMap[row][col]=GRID[row][col]==COLOR;
        if(GRID[row][col]==COLOR){
            int count = 0;
            if (isConnectBorder(row + 1, col)) count++;
            if (isConnectBorder(row - 1, col)) count++;
            if (isConnectBorder(row, col+  1)) count++;
            if (isConnectBorder(row, col - 1)) count++;
            if(count<4)
                GRID[row][col]=NEW_COLOR;
            return true;
        }
        return false;
    }
}
