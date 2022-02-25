package xyz.tong2.leetcode.question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author liwei04
 * @time 2022年01月14日 17:11
 */
public class No373KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        int i = 0;
        int j = 0;
        List<Integer> arr = new ArrayList<>(2);
        arr.add(nums1[i]);
        arr.add(nums2[j]);
        ans.add(arr);
        while (k>1){
            if(i== nums1.length - 1) {
                if (j == nums2.length - 1)
                    break;
                j++;
            }
            else if(j== nums2.length-1)
                i++;
            else if(nums1[i+1]-nums1[i]<=nums2[j+1]-nums2[j])
                i++;
            else
                j++;
            arr = new ArrayList<>(2);
            arr.add(nums1[i]);
            arr.add(nums2[j]);
            ans.add(arr);
            k--;
        }
        return ans;
    }
}
