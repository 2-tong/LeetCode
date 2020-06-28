package xyz.tong2.leetcode.recursion;

public class IsPalindrome_no9 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        String s = String.valueOf(x);

        int start = 0, end = s.length() - 1;
        while (start <= end){
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome_no9 solution = new IsPalindrome_no9();
        System.out.println(solution.isPalindrome(1212));
    }
}
