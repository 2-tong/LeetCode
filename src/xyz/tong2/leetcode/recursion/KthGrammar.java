package xyz.tong2.leetcode.recursion;

public class KthGrammar {
    public int kthGrammar(int N, int K) {
        if(K<=1)
            return 0;
        if(N==1)
            return 0;
        if((K&1)==1)
            return kthGrammar(--N,((K+1)>>1));
        else
            return kthGrammar(--N,((K+1)>>1))==1?0:1;
    }

    public static void main(String[] args) {
        KthGrammar K = new KthGrammar();
        System.out.println(K.kthGrammar(3,3));
    }
}
