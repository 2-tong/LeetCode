package xyz.tong2.leetcode.recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new LinkedList<>();
        if(n==1)
            list.add(new TreeNode(1));
        else {
            List<TreeNode> childlist = generateTrees(n-1);

        }
        return null;
    }
    public TreeNode copyTree(TreeNode base){
        if(base==null)
            return null;
        else {
            TreeNode t = new TreeNode(base.val);
            t.left = copyTree(base.left);
            t.right= copyTree(base.right);
            return t;
        }
    }


//    public List<TreeNode> addAnum(List<TreeNode> l,int number){
//
//        for(TreeNode tn:l){
//            Stack<TreeNode> stack = new Stack<>();
//            stack.push(tn);
//            boolean flag=true;
//            while (!stack.empty()) {
//                TreeNode cut = stack.peek();
//                if (cut.right != null&&flag) {
//                    stack.push(cut.left);
//                }
//                else {
//                    if (flag)
//                        flag=false;
//
//                }
//
//            }
//        }
//    }

}
