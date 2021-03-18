package xyz.tong2.leetcode.question;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年03月18日 09:33
 */
public class No448FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while(i<nums.length){
            int p1 = i;
            int n1 = nums[i];
            int p2 = n1-1;
            if(n1==0 || n1 == p1+1)
                i++;
            else if(nums[p2] != p2+1){
                nums[p1]=nums[p2];
                nums[p2]=n1;
            }
            else
                nums[p1] = 0;
        }
        List<Integer> list = new ArrayList<>();
        for(int j=0; j<nums.length;j++)
            if(nums[j]==0)
                list.add(j+1);
        return list;
    }
}
