package xyz.tong2.leetcode.question;

/**
 * TODO
 *
 * @author liwei04
 * @time 2022年02月23日 14:32
 */
public class No917ReverseOnlyLetters {
        public String reverseOnlyLetters(String s) {
            char[] arr = s.toCharArray();
            int start = 0;
            int end = arr.length-1;

            while (start<end){
                while (!Character.isLetter(arr[start])&&start<end) start++;
                while (!Character.isLetter(arr[end])&&end>=start) end--;
                if(start<end) {
                    char t = arr[start];
                    arr[start] = arr[end];
                    arr[end] = t;
                    start++;
                    end--;
                }
            }
            return new String(arr);
        }
}
