package xyz.tong2.leetcode.recursion;

import java.util.*;

public class Permute_no46 {
    private int[] array;
    private List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null)
            return ans;
        boolean[] used = new boolean[nums.length];
        array = nums;
        Integer[] ints = new Integer[0];
        processNums(used,ints);
        return ans;
    }

    private void processNums(boolean[] used,Integer[] nums){
        boolean isLast = (nums.length+1==used.length);
        for (int i = 0; i < used.length; i++) {
            if(!used[i]){
                Integer[] copy = Arrays.copyOf(nums,nums.length+1);
                copy[nums.length]=array[i];
                if(isLast){
                    List<Integer> list = new ArrayList<>(copy.length);
                    Collections.addAll(list,copy);
                    ans.add(list);
                    return;
                }
                else {
                    boolean[] usedCopy = Arrays.copyOf(used,used.length);
                    usedCopy[i]=true;
                    processNums(usedCopy,copy);
                }
            }
        }
    }

    public static void main(String[] args) {
        Permute_no46 solution = new Permute_no46();
        int[] nums = {};
        for (List<Integer> lis :
                solution.permute(nums)) {
            System.out.println(lis);
        }
    }
}
