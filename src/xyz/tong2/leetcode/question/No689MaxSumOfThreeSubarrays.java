package xyz.tong2.leetcode.question;

/**
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。
 * <p>
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 *
 * @author liwei04
 * @time 2021年12月08日 09:17
 */
public class No689MaxSumOfThreeSubarrays {
    public int[] maxSumOfThreeSubarrays_v1(int[] nums, int k) {
        int[] ans = new int[3];
        int max = 0;
        int[] sumK = new int[nums.length - k + 1];
        int[][] maxTwoSum = new int[sumK.length][2];
        for (int i = 0; i < k; i++) {
            sumK[0] += nums[i];
        }
        for (int i = 1; i < sumK.length; i++) {
            sumK[i] = sumK[i - 1] - nums[i - 1] + nums[k + i - 1];
        }

        for (int mid = k; mid <= (nums.length - k * 2); mid++) {
            for (int last = mid + k; last < sumK.length; last++) {
                int sum;
                sum = sumK[mid] + sumK[last];
                if (sum > maxTwoSum[mid][0]) {
                    maxTwoSum[mid][0] = sum;
                    maxTwoSum[mid][1] = last;
                }
            }
        }

        for (int first = 0; first <= (nums.length - k * 3); first++) {
            for (int mid = first + k; mid <= (nums.length - k * 2); mid++) {
                int sum;
                sum = sumK[first] + maxTwoSum[mid][0];
                if (sum > max) {
                    max = sum;
                    ans[0] = first;
                    ans[1] = mid;
                    ans[2] = maxTwoSum[mid][1];
                }
            }
        }
        return ans;
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int max;
        int[] sumK = new int[nums.length - k + 1];
        int[][] maxTwoSum = new int[sumK.length][2];
        for (int i = 0; i < k; i++) {
            sumK[0] += nums[i];
        }
        max = sumK[0];
        int step1Pos;
        for (int i = 1; i < sumK.length; i++) {
            sumK[i] = sumK[i - 1] - nums[i - 1] + nums[k + i - 1];
            if(sumK[i]>max){
                step1Pos = i;
                max = sumK[i];
            }
        }

        for (int mid = k; mid <= (nums.length - k * 2); mid++) {
            for (int last = mid + k; last < sumK.length; last++) {
                int sum;
                sum = sumK[mid] + sumK[last];
                if (sum > maxTwoSum[mid][0]) {
                    maxTwoSum[mid][0] = sum;
                    maxTwoSum[mid][1] = last;
                }
            }
        }

        for (int first = 0; first <= (nums.length - k * 3); first++) {
            for (int mid = first + k; mid <= (nums.length - k * 2); mid++) {
                int sum;
                sum = sumK[first] + maxTwoSum[mid][0];
                if (sum > max) {
                    max = sum;
                    ans[0] = first;
                    ans[1] = mid;
                    ans[2] = maxTwoSum[mid][1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 6, 7, 5, 1};
        No689MaxSumOfThreeSubarrays s = new No689MaxSumOfThreeSubarrays();
        s.maxSumOfThreeSubarrays(arr, 2);
    }
}
