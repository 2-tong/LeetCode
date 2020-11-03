package xyz.tong2.leetcode.test;

import java.util.*;

public class TestIn20615 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        Map<Integer,Integer> countCountMap = new HashMap<>();
        List<Integer> countSet = new LinkedList<>();

        int ans = 0;

        for (int n : arr) {
            int count = 0;
            if (!numCountMap.containsKey(n)) {
                ans++;
                numCountMap.put(n, 1);
            }
            else {
                count = numCountMap.get(n);
                numCountMap.put(n, count + 1);
            }
            if(count!=0)
                countCountMap.put(count,countCountMap.get(count)-1);

            count++;

            if(!countCountMap.containsKey(count)){
                countSet.add(count);
                countCountMap.put(count,1);
            }
            else {
                countCountMap.put(count,countCountMap.get(count)+1);
            }
        }
        for (int c :
                countSet) {
            int ccount = countCountMap.get(c);
            if (ccount != 0) {
                int x = c*ccount;
                if(x<k) {
                    ans -=ccount;
                    k-=x;
                }
                else {
                    int sub = k/c;
                    ans-=sub;
                    break;
                }
            }
        }
        return ans;
    }


    int[] parent;
    Map<Integer,TreeMap<Integer,Integer>> dp = new HashMap<>();

    public void TreeAncestor(int n, int[] parent) {
        this.parent = Arrays.copyOf(parent,n);
    }

    public int getKthAncestor(int node, int k) {
        if(k>0&&parent[node]==-1)
            return -1;

        if(dp.containsKey(node)){
            TreeMap<Integer,Integer> treeMap = dp.get(node);
            Map.Entry<Integer,Integer> entry= treeMap.floorEntry(k);
            if(entry!=null) {
                if (entry.getKey() == k)
                    return entry.getValue();
                else {
                    int ans = getKthAncestor(entry.getValue(), k - entry.getKey());
                    treeMap.put(k, ans);
                    return ans;
                }
            }
        }

        int ans;

        if(k==0)
            ans = node;
        else
            ans = getKthAncestor(parent[node],k-1);
        TreeMap<Integer,Integer> tMap= new TreeMap<>();
        tMap.put(k,ans);
        dp.put(node,tMap);
        return ans;

    }

}
