package xyz.tong2.leetcode.question;

public class No798BestRotation {
    public int bestRotation(int[] nums) {
        int[] inCount = new int[nums.length+2];
        int[] outCount = new int[nums.length+2];
        int maxIndex = nums.length - 1;
        int score = 0;
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]-i);
            if(nums[i]<=i) {
                inCount[abs+1]++;
                outCount[i]++;
                score++;
            }
            else {
                inCount[nums.length-abs+1]++;
                outCount[i]++;
            }
        }
        int ans = 0;
        int maxScore = score;
        for (int i = 1; i < nums.length; i++) {
            score -=(inCount[i]);
            score +=(outCount[i]);
            if(score>maxScore) {
                maxScore = score;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No798BestRotation rotation = new No798BestRotation();
        int[] arr2 = {1,2,3,4,5,0};
        int[] arr= {31,59,68,79,72,83,72,77,16,32,4,8,1,53,33,56,56,88,94,68,96,86,58,43,76,49,63,14,98,60,37,0,34,78,56,40,51,0,9,7,5,61,47,17,62,85,8,15,37,90,95,43,37,47,54,60,87,19,55,42,71,85,53,49,26,6,65,85,2,83,4,18,99,91,94,92,73,21,81,74,85,46,30,54,23,6,52,65,86,43,61,45,29,78,13,75,18,11,13,6};
        System.out.println(rotation.bestRotation(arr2));
    }
}
