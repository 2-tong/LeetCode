package xyz.tong2.leetcode.recursion;
import xyz.tong2.leetcode.recursion.GenerateTrees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class RecoverFromPreorder_no1028 {
    public TreeNode recoverFromPreorder(String S) {
        int i = 0;
        int len = S.length();

        Queue<TreeNode> stack= new LinkedList<>();

        while (i<S.length()){
            int num=0;
            while (i<len&&S.charAt(i)!='-') {
                num*=10;
                num+=S.charAt(i)-'0';
                i++;
            };

            int last = i;
            while (i<len&&S.charAt(i)=='-') i++;
            int nextDeep = i-last;


            if(stack.isEmpty())
                stack.add(new TreeNode(num));
            else {
                TreeNode node = stack.peek();
                if(node.left==null)
                    node.left = new TreeNode(num);
                else
                    node.right = new TreeNode(num);
            }


        }
        return null;
    }
}
