package xyz.tong2.leetcode.recursion;


public class FindMedianSortedArrays_no4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int allLen = nums1.length + nums2.length;

        int start = 0, end = nums1.length;

        int minCount1, minCount2,min = 0,max = 0;
        while (start <= end) {
            minCount1 = (start + end) >> 1;
            minCount2 = (allLen >> 1) - minCount1;
            min = Math.max(minCount2<=0?Integer.MIN_VALUE:nums2[minCount2-1],minCount1<=0?Integer.MIN_VALUE:nums1[minCount1-1]);
            max = Math.min(minCount2>=nums2.length?Integer.MAX_VALUE:nums2[minCount2],minCount1>=nums1.length?Integer.MAX_VALUE:nums1[minCount1]);
            if(min<=max)
                break;
            else if(minCount1!=0&&nums1[minCount1-1]>max)
                end=minCount1-1;
            else
                start=minCount1+1;
        }
        return (allLen&1)==1?(double)max:((double)max+min)/2;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays_no4 solution = new FindMedianSortedArrays_no4();
        int[] nums1 = {35};
        int[] nums2 = {40};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
