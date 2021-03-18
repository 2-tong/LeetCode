package xyz.tong2.leetcode.question;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年03月18日 09:28
 */
public class No461HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = x^y;
        int result = 0;
        for(int i = 1;i<32;i++){
            result+=(count&1);
            count=count>>1;
        }
        return result;
    }
}
