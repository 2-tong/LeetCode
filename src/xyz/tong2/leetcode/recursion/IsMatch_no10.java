package xyz.tong2.leetcode.recursion;

public class IsMatch_no10 {

    boolean checkChar(char s,char p){
        return p == '.' || s == p;
    }

    public boolean isMatch(String s, String p) {
        int sIndex=0;
        int pIndex=0;

        while (sIndex<s.length()||pIndex<p.length()){
            if(pIndex>=p.length())
                return false;

            if(p.charAt(pIndex)=='*'){
                char key = p.charAt(pIndex-1);
                int startS = sIndex;
                while (sIndex<s.length()&&checkChar(s.charAt(sIndex),key))
                    sIndex++;
                pIndex++;
                if(pIndex<p.length()&&checkChar(key,p.charAt(pIndex))){
                    for (int i = startS; i <=sIndex-1 ; i++) {
                        if(isMatch(s.substring(i),p.substring(pIndex)))
                            return true;
                    }
                }
            }
            else {
                if(pIndex<p.length()-1&&p.charAt(pIndex+1)=='*')
                    pIndex++;
                else if(sIndex>=s.length())
                    return false;
                else if(!checkChar(s.charAt(sIndex),p.charAt(pIndex)))
                    return false;
                else {
                    pIndex++;
                    sIndex++;
                }
            }


        }

        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        String p = "";
        IsMatch_no10 solution = new IsMatch_no10();
        System.out.println(solution.isMatch(s, p));
    }
}
