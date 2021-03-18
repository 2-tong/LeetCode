package xyz.tong2.leetcode.question;

import xyz.tong2.leetcode.util.TreeNode;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年03月18日 09:30
 */
public class No226InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
