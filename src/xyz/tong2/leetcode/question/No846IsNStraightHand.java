package xyz.tong2.leetcode.question;

import java.util.Arrays;

/**
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 *
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 *
 * @author liwei04
 * @time 2021年12月30日 14:35
 */
public class No846IsNStraightHand {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
            return false;
        Arrays.sort(hand);
        for (int i = 0; i < hand.length;) {
            int curCount = groupSize-1;
            int chk = hand[i]+1;
            int pos = -1;
            hand[i]=-2;
            i++;
            while (i < hand.length&&curCount!=0){
                if(hand[i]==chk){
                    curCount--;
                    hand[i]=-2;
                    i++;
                    chk++;
                }
                else if(hand[i]==chk-1||hand[i]==-2){
                    if(pos==-1&&hand[i]==chk-1){
                        pos = i;
                    }
                    i++;
                }
                else
                    return false;
            }
            if(curCount!=0)
                return false;
            if(pos!=-1)
                i=pos;
        }
        return true;
    }

    public static void main(String[] args) {
        No846IsNStraightHand straightHand  = new No846IsNStraightHand();
        int[] arr = {1,2,3,6,2,3,4,7,8};
        Integer i = 0;
        System.out.println(straightHand.isNStraightHand(arr,3));
    }
}
