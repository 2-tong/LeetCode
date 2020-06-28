package xyz.tong2.leetcode.recursion;
import xyz.tong2.leetcode.recursion.GenerateTrees.TreeNode;

public class MaxPathSum_no124 {
    private int maxNum;
    public int maxPathSum(TreeNode root) {
        if(root!=null)
            maxNum=root.val;
        int ans = process(root)[1];
        return maxNum<0?maxNum:ans;
    }

    public int[] process(TreeNode root) {
        if(root==null)
            return new int[2];
        maxNum=Math.max(maxNum,root.val);

        int[] leftAns,rightAns;

        leftAns = process(root.left);
        rightAns = process(root.right);

        int[] ans = new int[2];
        ans[0]=Math.max(Math.max(leftAns[0], rightAns[0])+root.val, 0);
        ans[1]=Math.max(Math.max(leftAns[1],rightAns[1]),
                leftAns[0]+rightAns[0]+root.val);

        return ans;
    }
}
