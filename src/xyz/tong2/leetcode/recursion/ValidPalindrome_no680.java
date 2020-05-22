package xyz.tong2.leetcode.recursion;

public class ValidPalindrome_no680 {
    public boolean validPalindrome(String s) {
        return validPalindromeChild(s,0,s.length()-1,true);
    }

    private boolean validPalindromeChild(String s,int start,int end,boolean wrongChance){
        while (end>=start){
            if(s.charAt(start)!=s.charAt(end))
                return wrongChance && (validPalindromeChild(s, start + 1, end, false)
                        || validPalindromeChild(s, start, end - 1, false));
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_no680 solution = new ValidPalindrome_no680();
        String str = "q";
        System.out.println(solution.validPalindrome(str));
    }
}
