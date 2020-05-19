package xyz.tong2.leetcode.recursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/***
 * No.39
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum_no39 {
    //使用hashMap存储组成k的所有可能的组合
    Map<Integer,List<List<Integer>>> dp = new HashMap<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(dp.containsKey(target))
            return dp.get(target);

        List<List<Integer>> ans = new LinkedList<>();

        //遍历所有的candidates,递归找到可以组成target - candidate的所有组合
        for (int candidate : candidates) {

            //大于target一半的candidate会在小于target一半的candidate的递归返回值中出现
            if (candidate <= target / 2) {
                List<List<Integer>> lists = combinationSum(candidates, target - candidate);
                for (List<Integer> list :
                        lists) {
                    //配合上面的if玄学去重
                    if (list.get(0) >= candidate) {
                        List<Integer> newList = new LinkedList<>();
                        newList.add(candidate);
                        newList.addAll(list);
                        ans.add(newList);
                    }
                }
            } else if (candidate == target) {
                List<Integer> list = new LinkedList<>();
                list.add(candidate);
                ans.add(list);
            }
        }
        dp.put(target,ans);
        return ans;
    }

    public static void main(String[] args) {
        CombinationSum_no39 solution = new CombinationSum_no39();
        int[] nums={2,3,5};
        System.out.println(solution.combinationSum(nums, 8));
    }
}
