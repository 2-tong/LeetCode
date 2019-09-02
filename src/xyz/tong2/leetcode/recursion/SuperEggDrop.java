package xyz.tong2.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop {
    Map<Integer,Integer> map = new HashMap<>();
    int count=0;

    public int superEggDrop(int K, int N) {

        if(K==1||N<=2)
            return N;
        int key = N*100+K;
        if(map.containsKey(key))
            return map.get(key);
        count++;
        int div=(N+1)/2;
        int min = 0;
        int cutmin= Integer.MAX_VALUE;
        int i = div;
        int lo=1;int hi=N;
        while (lo+1<hi){
            int n1 = superEggDrop(K-1,i-1);
            int n2 = superEggDrop(K,N-i);

            if(n1-n2>0)
                hi=i;
            else if(n1-n2<0)
                lo=i;
            else
                hi=lo=i;

            i=(lo + hi) / 2;
        }
        min = Math.min(Math.max(superEggDrop(K-1,lo-1),superEggDrop(K,N-lo)),Math.max(superEggDrop(K-1,hi-1),superEggDrop(K,N-hi)));
        map.put(key,min+1);
        return min+1;
    }

    public static void main(String[] args) {
        SuperEggDrop se = new SuperEggDrop();
        System.out.println(se.superEggDrop(100,10000));
        System.out.println("时间复杂："+se.count);
    }
}
