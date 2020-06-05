package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class SpiralOrder_no29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        int[] ans = new int[matrix.length*matrix[0].length];
        int rowMax = matrix.length-1,colMax = matrix[0].length-1;
        int i=0,row=0,col=0;
        int[][] direction = {{0,1},
                    {1,0},
                    {0,-1},
                    {-1,0}};
        int d=colMax==0?1:0;
        while (i<ans.length){
            ans[i]=matrix[row][col];
            row+=direction[d][0];
            col+=direction[d][1];
            if(d==0){
                if (col == colMax - row)
                    d++;
            }
            else if (d==1){
                if (row == rowMax-colMax+col)
                    d++;
            }else if(d==2){
                if (col == rowMax-row)
                    d++;
            }
            else{
                if (row ==col+1)
                    d=0;
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        SpiralOrder_no29 solution = new SpiralOrder_no29();
        int[][] m = {{1},
                {21},
                {31}};
        System.out.println(Arrays.toString(solution.spiralOrder(m)));
    }
}
