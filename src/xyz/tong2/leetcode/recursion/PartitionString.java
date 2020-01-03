package xyz.tong2.leetcode.recursion;

import java.util.*;

public class PartitionString {
    private IsPalindrome ip = new IsPalindrome();
    public List<List<String>> partition(String s) {
        if(s.length()==0)
            return new LinkedList<List<String>>();
        LinkedList<List<String>> resultList = new LinkedList<>();
        if(s.length()==1){
            LinkedList<String> slist = new LinkedList<String>();
            slist.add(new String(s.toCharArray()));
            resultList.add(slist);
            return resultList;
        }
        int i=0;
        char[] strc = s.toCharArray();
        for( i = 1;i<=strc.length;i++){
            if(ip.isPalindrome(strc,0,i)){
                List<List<String>> rst = partition(new String(strc,i,strc.length-i));

                if(rst.size()!=0)
                    for (List<String> ls:rst){
                        LinkedList<String> lkls = (LinkedList<String>) ls;
                        lkls.addFirst(new String(strc,0,i));
                        resultList.add(ls);
                    }
                else{
                    LinkedList<String> list = new LinkedList<String>();
                    list.addFirst(new String(strc,0,i));
                    resultList.add(list);
                }
            }
        }

        return resultList;
    }


    public static class IsPalindrome {
        Map<String,Boolean> palindromeMap = new HashMap();

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

            String key = new String(s,begin,end-begin);
            if(palindromeMap.containsKey(key))
                return palindromeMap.get(key);

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
                if(!equalsIgnoreCase(chars[start],chars[last])) {
                    palindromeMap.put(key,false);
                    return false;
                }
                start++;
                last--;
            }
            palindromeMap.put(key,true);
            return true;
        }

        private boolean equalsIgnoreCase(char c1,char c2){
            c1 = Character.toLowerCase(c1);
            c2 = Character.toLowerCase(c2);
            return c1 == c2;
        }

    }

    public static void main(String[] args) {
        String s = "ddsddsdd";
        PartitionString ps = new PartitionString();
        var ss = ps.partition(s);
        System.out.println(ss.toString());
    }


}
