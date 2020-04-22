package xyz.tong2.leetcode.recursion;

import java.util.Stack;

public class LongestValidParentheses_no32 {



    public int longestValidParentheses(String s) {
        if(s==null||s.length()<2)
            return 0;

        boolean[] buffer = new boolean[s.length()];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.empty() && s.charAt(i)==')' && s.charAt(stack.peek())=='('){
                    buffer[stack.pop()]=true;
                    buffer[i]=true;
            }
            else
                stack.push(i);
        }

        int start=0,ans=0;
        while (start<s.length()&&!buffer[start])
            start++;

        for (int i = start+1; i < s.length(); i++) {
            if(!buffer[i]){
                ans=Math.max(i-start,ans);
                start = i+1;
                while (start<s.length()&&!buffer[start])
                    start++;
                i=start+1;
            }
            else if(i==s.length()-1){
                ans=Math.max(i-start+1,ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestValidParentheses_no32 solution =new  LongestValidParentheses_no32();
        System.out.println(solution.longestValidParentheses("("));
    }
}
