package xyz.tong2.leetcode.recursion;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis_no22 {
    private List<String> ans = new LinkedList<>();
    char[] arrays=null;
    int N=0;
    private void generate(int i,int leftCount,int rightCount){
        if(i==arrays.length)
            ans.add(new String(arrays));
        else {
            if(leftCount!=N){
                arrays[i]='(';
                generate(i+1,leftCount+1,rightCount);
            }
            if(i!=0&&rightCount<leftCount){
                arrays[i]=')';
                generate(i+1,leftCount,rightCount+1);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        N=n;
        arrays = new char[n<<1];
        generate(0,0,0);
        return ans;
    }
}
