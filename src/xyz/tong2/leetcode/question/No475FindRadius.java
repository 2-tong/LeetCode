package xyz.tong2.leetcode.question;

import java.util.Arrays;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年12月21日 14:03
 */
public class No475FindRadius {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = Math.abs(houses[0]-heaters[0]);
        int posH=0;
        int posW=0;
        for (; posH < houses.length; posH++) {
            int min ,curMin;
            min = Math.abs(houses[posH]-heaters[posW]);
            while (posW<heaters.length&&
                    (curMin = Math.abs(houses[posH]-heaters[posW]))<=min){
                min=curMin;
                posW++;
            }
            max = Math.max(min,max);
            if (posW>0)
                posW--;
        }
        String x = "21";
        int s = Integer.parseInt(x);
        return max;
    }
}
