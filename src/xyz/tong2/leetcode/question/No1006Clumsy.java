package xyz.tong2.leetcode.question;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年04月01日 10:59
 */
public class No1006Clumsy {

    int[][] preAns = {{1,1},{2,2},{6,6},{7,6}};

    public int clumsy(int N) {
        return process(N)[0];
    }

    private int[] process(int N) {
        if(N<5){
            return preAns[N-1];
        }

        int[] ans = new int[2];
        ans[1] = N*(N-1)/(N-2);
        int pre = ans[1]+N-3;
        int[] next = process(N-4);
        ans[0] = pre + next[0] - 2*next[1];
        return ans;
    }

    public static void main(String[] args) {
        No1006Clumsy clumsy = new No1006Clumsy();

        System.out.println(clumsy.clumsy(10));
    }
}
