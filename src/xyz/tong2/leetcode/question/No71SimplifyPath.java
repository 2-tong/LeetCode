package xyz.tong2.leetcode.question;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/simplify-path/">简化路径</a>
 *
 * @author liwei04
 * @time 2022年01月06日 09:20
 */
public class No71SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if(!".".equals(p)&&!p.isEmpty()){
                if(p.equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else
                    stack.push(p);
            }
        }
        if(stack.isEmpty())
                return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append("/").append(stack.pollLast());
        return sb.toString();
    }

    public static void main(String[] args) {
        No71SimplifyPath pathUtil = new No71SimplifyPath();
        System.out.println(pathUtil.simplifyPath("/a/./b///c/../c/"));
    }
}
