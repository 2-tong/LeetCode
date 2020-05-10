package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class Rotate_no48 {
    public void rotate(int[][] matrix) {
        int half =   matrix.length / 2;
        for (int i = 0; i <half; i++) {
            for (int j = i; j <matrix.length-i-1 ; j++) {
                rotate4group(matrix,i,j);
            }
        }
    }
    private void rotate4group(int[][] matrix,int row,int col){
        int[][] poses = getPoses(row,col,matrix.length-1);

        int tmp = matrix[poses[1][0]][poses[1][1]];
        matrix[poses[1][0]][poses[1][1]]=matrix[poses[0][0]][poses[0][1]];
        matrix[poses[0][0]][poses[0][1]]=tmp;

        tmp = matrix[poses[2][0]][poses[2][1]];
        matrix[poses[2][0]][poses[2][1]]=matrix[poses[3][0]][poses[3][1]];
        matrix[poses[3][0]][poses[3][1]]=tmp;

        tmp = matrix[poses[0][0]][poses[0][1]];
        matrix[poses[0][0]][poses[0][1]]=matrix[poses[2][0]][poses[2][1]];
        matrix[poses[2][0]][poses[2][1]]=tmp;
    }

    private int[][] getPoses(int row,int col,int maxIndex){
        int[][] poses = new int[4][2];
        poses[0][0]=row;
        poses[0][1]=col;

        for (int i = 1; i < poses.length; i++) {
            poses[i][0]=poses[i-1][1];
            poses[i][1]=maxIndex-poses[i-1][0];
        }

        return poses;
    }

    public static void main(String[] args) {
        Rotate_no48 solution = new Rotate_no48();
        int[][] rotate = {
                {1}};
        solution.rotate(rotate);
        for (int[] ints : rotate) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
