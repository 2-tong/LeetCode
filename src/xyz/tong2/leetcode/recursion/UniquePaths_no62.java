package xyz.tong2.leetcode.recursion;

public class UniquePaths_no62 {
    public int uniquePaths(int m, int n) {
        if(m==1||n==1)
            return 1;
        long a = 1,div =1;
        int min = Math.min(m, n);
        int all = m+n-1;
        for (int i = 1; i < min; i++) {
            a*=(all-i);
            div*=i;
        }
        return (int) (a/div);
    }

    public static void main(String[] args) {
        UniquePaths_no62 solution = new UniquePaths_no62();
        System.out.println(solution.uniquePaths(10, 9));
    }
}
