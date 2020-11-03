package xyz.tong2.leetcode.question;

import java.util.Queue;

public class No44IsMatch {
    boolean checkChar(char s,char p){
        return p == '?' || s == p;
    }
    public boolean isMatch(String s, String p) {
        int sIndex = 0,pIndex = 0;
        while (sIndex<s.length()||pIndex<p.length()){
            if(p.charAt(pIndex)!='*'){
                if(pIndex>0&&p.charAt(pIndex-1)=='*'){

                }
                else
                {
                    if(!checkChar(s.charAt(sIndex),p.charAt(pIndex)))
                        return false;
                }
            }
        }
        return true;
    }
}
