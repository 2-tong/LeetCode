package xyz.tong2.leetcode.recursion;

/**
 * 力扣-169题：
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class MajorityElement {
    public int majorityElement(int[] nums) {

        //按位统计1出现的次数
        int[] count = new int[32];
        for (int num : nums) {

            for (int j = 0; j < 32; j++) {
                count[j] += ((num >> j) & 1);
            }
        }
        int res=0;

        //如果次数大于1/2则该位为1
        for (int j = 0; j < 32; j++) {
            if(count[j]>(nums.length/2))
                res=res|(1<<j);
        }
        return res;
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int[] ns = {7,3,15,3,15,8,15,15,15,56,15,78,15};
        System.out.println(m.majorityElement(ns));
    }
}
