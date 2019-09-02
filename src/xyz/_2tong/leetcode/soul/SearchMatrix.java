package xyz._2tong.leetcode.soul;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        return false;
    }
    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();
        int arr[][]={
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int arr2[][]={
                {1, 1}
        };

        System.out.println(sm.searchMatrix(arr2,0));
    }

}
