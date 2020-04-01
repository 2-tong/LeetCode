package xyz.tong2.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class CountSubstrings_no647 {
    public int countSubstrings(String s) {

        if(s==null)
            return 0;
        if(s.length()<2)
            return s.length();
        final int MIN_INDEX = 0;
        final int MAX_INDEX = s.length() - 1;
        char[] array = s.toCharArray();
        int ans = s.length(); //所有单个字符都为回文串
        List<Integer> subStr2=new ArrayList<>(s.length()-1);
        List<Integer> subStr3=new ArrayList<>(s.length()-1);
        for(int i=0;i<s.length()-2;i++) {
            if (array[i] == array[i + 1])
            {
                subStr2.add(i);
                ans++;
            }
            if (array[i] == array[i + 2]) {
                subStr3.add(i);
                ans++;
            }
        }

        if(s.length()>1)
            if(array[s.length()-1]==array[s.length()-2]){
                subStr2.add(s.length()-2);
                ans++;
            }

        for (int i :
                subStr2) {
            int start = i-1;
            int end = i+2;
            while (start>=MIN_INDEX&&end<=MAX_INDEX)
                if(array[start--]==array[end++])
                    ans++;
                else
                    break;
        }
        for (int i :
                subStr3) {
            int start = i-1;
            int end = i+3;
            while (start>=MIN_INDEX&&end<=MAX_INDEX)
                if(array[start--]==array[end++])
                    ans++;
                else
                    break;
        }
        return ans;
    }

    public static void main(String[] args) {
        String subTest = "dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg";
        System.out.println(subTest.length());
        CountSubstrings_no647 countSubstrings = new CountSubstrings_no647();
        System.out.println(countSubstrings.countSubstrings(subTest));
    }
}
