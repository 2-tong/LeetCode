package xyz.tong2.leetcode.recursion;

import java.util.*;

public class LevelOrder_no102 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    List<List<Integer>> ansList= new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        process(root,0);
        return ansList;
    }

    private void process(TreeNode root, int level) {
        if (root != null) {
            if (ansList.size()<level+1)
                ansList.add(new LinkedList<>());
            ansList.get(level).add(root.val);
            process(root.left, level + 1);
            process(root.right, level + 1);
        }
    }

    //BFS解法
    public List<List<Integer>> levelOrderSolution2(TreeNode root) {
        List<List<Integer>>  ansList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null)
            return ansList;
        queue.add(root);

        List<Integer> currentList=null;
        int currentLevelCount  = 1;
        int nextLevelCount = 0;
        int level=1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(ansList.size()<level)
                ansList.add(currentList=new LinkedList<>());
            currentList.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
                nextLevelCount++;
            }
            if(node.right!=null){
                queue.add(node.right);
                nextLevelCount++;
            }
            currentLevelCount--;
            if(currentLevelCount==0){
                currentLevelCount=nextLevelCount;
                nextLevelCount=0;
                level++;
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        LevelOrder_no102 solution = new LevelOrder_no102();
        TreeNode r = new TreeNode(20);
        r.left=new TreeNode(15);
        r.right=new TreeNode(7);
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right=r;

        root = new TreeNode(9);

        System.out.println(solution.levelOrderSolution2(root));

    }
}
