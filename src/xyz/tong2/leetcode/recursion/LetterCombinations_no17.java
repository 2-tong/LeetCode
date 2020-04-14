package xyz.tong2.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations_no17 {
    private char[][] dict = {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    private List<String> ans =new LinkedList<>();
    private String digitStr = null;

    private int getIndex(char digit){
        return digit-'2';
    }
    private void processDig(char[] str){
        if(str.length == digitStr.length())
            ans.add(new String(str));
        else {
            char key = digitStr.charAt(str.length);
            for (int i = 0; i < dict[getIndex(key)].length; i++) {
                char[] array = Arrays.copyOf(str,str.length+1);
                array[str.length]=dict[getIndex(key)][i];
                processDig(array);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        digitStr = digits;
        if(digits.length()>0){
            char firstKey = digits.charAt(0);
            for (int i = 0; i < dict[getIndex(firstKey)].length; i++) {
                char[] array = new char[1];
                array[0]=dict[getIndex(firstKey)][i];
                processDig(array);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LetterCombinations_no17 solution = new LetterCombinations_no17();
        System.out.println(solution.letterCombinations("54658"));
    }
}
