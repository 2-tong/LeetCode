package xyz.tong2.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies_no1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> ans = new ArrayList<>(candies.length);
        for (int count :
                candies) {
            if (count > max)
                max=count;
        }

        for (int candy : candies) {
            ans.add(candy + extraCandies >= max);
        }
        return ans;
    }

    public static void main(String[] args) {
        KidsWithCandies_no1431 solution = new KidsWithCandies_no1431();
        System.out.println(solution.kidsWithCandies(new int[]{5, 3, 5, 4, 9, 4, 3, 7}, 10));
    }

}
