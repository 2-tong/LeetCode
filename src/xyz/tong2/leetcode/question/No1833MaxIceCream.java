package xyz.tong2.leetcode.question;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年07月02日 15:05
 */
public class No1833MaxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(costs.length, (o1, o2) -> costs[o2]-costs[o1]);
        for (int i = 0; i < costs.length; i++) {
            priorityQueue.add(i);
            coins-=costs[i];
            if(coins<0){
                Integer index = priorityQueue.poll();
                if(index!=null){
                    coins+=costs[index];
                }
            }
        }
        return priorityQueue.size();
    }
}
