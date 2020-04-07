package xyz.tong2.leetcode.recursion;

public class LongestPalindrome_no5 {
    public String longestPalindrome(String s) {

        if(s.length()<2)
            return s;
        char[] chars = new char[s.length()*2+1];
        int[] longestCount = new int[s.length()*2+1];

        //准备字符串（加入#）
        for (int i = 0; i < s.length();i++) {
            chars[i*2]='#';
            chars[i*2+1]=s.charAt(i);
        }
        chars[chars.length-1]='#';

        int ansCenter=0;
        int ansLength=0;

        for (int i = 1; i < chars.length; i++) {
            int len = 0;
            int j = 2;

            while ((i-j)>0) {
                len = Math.max(len, longestCount[i - j]);
                j*=2;
            }
            len++;

            while (i-len>=0&&i+len<=chars.length-1){
                if(chars[i-len]==chars[i+len]) {
                    if(len>ansLength){
                        ansCenter=i;
                        ansLength=len;
                    }
                    else if(len==ansLength&&(ansCenter&1)==1){
                        ansCenter=i;
                        ansLength=len;
                    }
                    len++;
                }
                else
                    break;
            }
            if(len+i>=chars.length-1)
                break;
        }
        StringBuffer sb=new StringBuffer();
        for (int i=ansCenter-ansLength;i<=ansCenter+ansLength;i++){
            if(chars[i]!='#')
                sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "babadada";
        LongestPalindrome_no5 solution = new LongestPalindrome_no5();
        System.out.println(solution.longestPalindrome(str));
    }
}
