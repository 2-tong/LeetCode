package xyz.tong2.leetcode.question;

public class No861MatrixScore {
    public int matrixScore(int[][] A) {
        int count = A.length;
        int bits = A[0].length;

        int[] bitSum = new int[bits];
        bitSum[0] = count;
        boolean translate;
        for (int[] ints : A) {
            translate = ints[0] == 0;
            for (int j = 1; j < bits; j++) {
                if ((translate && ints[j] == 0) || (!translate && ints[j] != 0))
                    bitSum[j]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < bits; i++) {
            sum += ((bitSum[i] <= count / 2 ? count - bitSum[i] : bitSum[i]) << (bits - i - 1));
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {

                {0,0,1,1},{1,0,1,0},{1,1,0,0}
        };

        No861MatrixScore sol = new No861MatrixScore();
        System.out.println(sol.matrixScore(A));
    }
}
