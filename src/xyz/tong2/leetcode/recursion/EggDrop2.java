package xyz.tong2.leetcode.recursion;

public class EggDrop2 {
    int[][] map;
    public int deep(int K,int N){
        if (K == 1 || N <= 2)
            return N;
        if(map[K][N]!=-1)
            return map[K][N];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            int lo = deep(K - 1, i-1);
            int hi = deep(K,N-i);

            int max = Math.max(lo,hi);
            min = Math.min(min,max+1);
        }
        map[K][N]=min;
        return min;
    }

    public int superEggDrop(int K, int N) {
        map = new int[K+1][N+1];
        for (int i=0;i<=K;i++)
            for(int k=0;k<=N;k++)
                map[i][k]=-1;

        return deep(K,N);
    }

    public static void main(String[] args) {
        int K=4;
        int N=1000;
        int ans = new EggDrop2().superEggDrop(K,N);
        int ans2 = new SuperEggDrop().superEggDrop(K,N);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
