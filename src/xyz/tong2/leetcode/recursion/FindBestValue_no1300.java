package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class FindBestValue_no1300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int sub = Math.abs(target%arr.length);
        int ans = target/arr.length;
        if(sub>(arr.length>>1)) {
            ans=target<0?ans-1:ans+1;
            sub=arr.length-sub;
        }
        if(ans >= arr[0]) {
            ans = arr[0] - 1;
            sub=Math.abs(target-ans*arr.length);
        }

        int sum = 0,len = arr.length;
        for (int i = 0; i < arr.length-1; i++) {
            sum+=arr[i];
            int count = len-1-i;
            int div = (target-sum)/count;
            int rem = Math.abs((target-sum)%count);
            if(rem>(count>>1)){
                div=(target-sum)<0?div-1:div+1;
            }
            if(div<arr[i])
                div=arr[i];
            else if(div>=arr[i+1])
                div=arr[i+1]-1;

            rem = Math.abs(target-sum-(div*count));

            if(rem<sub) {
                ans = div;
                sub=rem;
            }
        }
        sum+=arr[arr.length-1];
        if(Math.abs(target-sum)<sub)
            ans=arr[arr.length-1];
        return ans;
    }

    public static void main(String[] args) {
        FindBestValue_no1300 solution = new FindBestValue_no1300();
        int[] arr = {1547,83230,57084,93444,70879};
        int tag = 71237;

        System.out.println(solution.findBestValue(arr, tag));
    }
}
