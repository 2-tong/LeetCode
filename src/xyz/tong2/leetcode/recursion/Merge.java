package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0&&n==0)
            return;
        int x=0,y=0;
        int[] num1copy = Arrays.copyOf(nums1,m);
        for (int i =0;x<m||y<n;i++){
            if(y>=n||(x<m&&num1copy[x]<=nums2[y])){
                nums1[i]=num1copy[x++];
            }
            else if(y<n){
                nums1[i]=nums2[y++];
            }
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int n1[] = {1,2,3,4,5,8,11,45,56,0,0,0,0,0,0,0};
        int m =9;
        int n2[] ={2,5,6,7,8,45,46};
        int n =7;
        merge.merge(n1,m,n2,n);
        System.out.println(Arrays.toString(n1));
    }
}
