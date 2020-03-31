package xyz.tong2.leetcode.recursion;

import java.util.*;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.empty()&&T[i] > T[stack.peek()]) {
                int loc = stack.pop();
                result[loc] = i - loc;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73,75};
        DailyTemperatures dalyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dalyTemperatures.dailyTemperatures(temperatures)));
    }
}
