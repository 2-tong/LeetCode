package xyz.tong2.leetcode.question;

import java.util.*;

public class No350Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length){
            int[] tmp = nums1;
            nums1=nums2;
            nums2=tmp;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n : nums1) {
            if(!map.containsKey(n))
                map.put(n,1);
            else
                map.put(n,map.get(n)+1);
        }

        List<Integer> ans = new LinkedList<>();

        for (int n : nums2) {
            if(map.containsKey(n)&&map.get(n)>0) {
                ans.add(n);
                map.put(n,map.get(n)-1);
            }
        }
        int[] ansArray = new int[ans.size()];

        Iterator<Integer> iterator = ans.iterator();
        int i=0;
        while (iterator.hasNext())
            ansArray[i++]=iterator.next();

        return ansArray;
    }
}
