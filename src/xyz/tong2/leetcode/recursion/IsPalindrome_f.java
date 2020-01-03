package xyz.tong2.leetcode.recursion;

import java.util.Arrays;

public class IsPalindrome_f {
    public boolean isPalindrome(String s) {
        if(s==null)
            return false;
        if(s.equals(""))
            return true;

        char[] chars = s.toCharArray();
        int start=0;
        int last=chars.length-1;

        while (start<last){
            if(!Character.isLetterOrDigit(chars[start])) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[last])) {
                last--;
                continue;
            }
            if(!equalsIgnoreCase(chars[start],chars[last]))
                return false;
            start++;
            last--;
        }
        return true;
    }

    public boolean isPalindrome(char[] s,int begin,int end) {
        if(s==null)
            return false;
        if(s.length==0)
            return true;

        char[] chars = Arrays.copyOfRange(s,begin,end);
        int start=0;
        int last=chars.length-1;

        while (start<last){
            if(!Character.isLetterOrDigit(chars[start])) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[last])) {
                last--;
                continue;
            }
            if(!equalsIgnoreCase(chars[start],chars[last]))
                return false;
            start++;
            last--;
        }
        return true;
    }

    private boolean equalsIgnoreCase(char c1,char c2){
        c1 = Character.toLowerCase(c1);
        c2 = Character.toLowerCase(c2);
        return c1 == c2;
    }

    public static void main(String[] args) {
        IsPalindrome_f i = new IsPalindrome_f();
        String s ="A man, a plan, a canal: Panama";
        String s1 = ".as,";
        System.out.println(i.isPalindrome(s1));
    }

}
