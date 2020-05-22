package xyz.tong2.leetcode.recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import xyz.tong2.leetcode.recursion.LevelOrder_no102.TreeNode;

public class BuildTree_no105 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> added = new HashSet<>();
        int i =0;

        boolean onLeft = true;
        if(preorder[0]==inorder[0]){
            onLeft=false;
            i++;
        }
        TreeNode ans = new TreeNode(preorder[0]);
        stack.push(ans);
        added.add(ans.val);
        for (int p = 1; p < preorder.length; p++) {
            TreeNode node = new TreeNode(preorder[p]);
            if(onLeft){
                stack.peek().left=node;
            }else {
                while (i<inorder.length&&added.contains(inorder[i]))
                    i++;
                while (stack.peek().val!=inorder[i-1])
                    stack.pop();

                stack.peek().right=node;
                stack.pop();
            }
            stack.push(node);

            if(preorder[p]==inorder[i]) {
                onLeft = false;
                i++;
            }else
                onLeft=true;

            added.add(node.val);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] preorder = {1,2,3,4,5,6,7};
        int[] inorder  = {1,2,3,4,5,6,7};
        BuildTree_no105 solution = new BuildTree_no105();
        TreeNode root = solution.buildTree(preorder,inorder);

        LevelOrder_no102 tree2StrUtil = new LevelOrder_no102();

        System.out.println(tree2StrUtil.levelOrderSolution2(root).toString());
    }
}
