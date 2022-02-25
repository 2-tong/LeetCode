package xyz.tong2.leetcode.question;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/">括号的最大嵌套深度</a>
 *
 * @author liwei04
 * @time 2022年01月07日 10:10
 */
public class No1614MaxDepth {
    public int maxDepth(String s) {
        int leftCount = 0;
        int max = 0;
        for (int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                leftCount++;
                max = Math.max(leftCount,max);
            }
            else if(s.charAt(i)==')'){
                leftCount--;
            }
        }
        return max;
    }
}
