package xyz.tong2.leetcode.question;

import xyz.tong2.leetcode.util.TreeNode;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年03月18日 09:29
 */
public class No617MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode result;
        if(root1 == null & root2 == null)
            return null;
        if(root1 == null)
            return root2;
        else if(root2 == null)
            return root1;
        else{
            root1.val+=root2.val;
            result = root1;
        }
        result.left=mergeTrees(root1.left,root2.left);
        result.right=mergeTrees(root1.right,root2.right);
        return result;
    }
}
