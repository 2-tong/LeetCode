package xyz.tong2.leetcode.question;

public class No378KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        if(k==1)
            return matrix[0][0];
        int row=0,col = 0;
        int rOffset=1,cOffset = 1;
        k--;
        while (k>1){
            if(matrix[row][col+cOffset]<matrix[row+rOffset][col]) {
                cOffset++;
            }
            else {
                rOffset++;
            }
            k--;
        }
        return Math.min(matrix[row][0],matrix[0][col]);
    }

}
