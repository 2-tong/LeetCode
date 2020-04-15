package xyz.tong2.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class IsValid_no20 {
    public boolean isValid(String s) {
        if(s==null||s.length()==0)
            return true;
        if((s.length()&1)==1)
            return false;
        char[] stack = new char[s.length()>>1];
        int point = 1;
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        if(!map.containsKey(s.charAt(0)))
            return false;
        stack[0]=s.charAt(0);
        for (int i = 1; i < s.length(); i++) {

            if(point!=0&&map.get(stack[point-1])==s.charAt(i))
                point--;
            else {
                if(point==stack.length||!map.containsKey(s.charAt(i)))
                    return false;
                stack[point++]=s.charAt(i);
            }
        }
        if(point==0)
            return true;
        return false;
    }
    public static void main(String[] args) {
        String test = "}{";
        IsValid_no20 solution = new IsValid_no20();
        System.out.println(solution.isValid(test));
    }
}
