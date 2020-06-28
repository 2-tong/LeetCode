package xyz.tong2.leetcode.recursion;

public class TranslateNum_noms46 {
    public int translateNum(int num) {

        int[] count = new int[2];
        int p=0;
        int lastN = num%10;
        count[0]=1;
        count[1]=1;
        num/=10;
        while (num !=0){
            int b =  num%10;
            int t = b*10+lastN;
            p = p==0?1:0;
            if(t<26&&t>9)
                count[p]=count[0]+count[1];
            else
                count[p]=count[p==0?1:0];
            lastN=b;
            num/=10;
        }
        return count[p];
    }


    public static void main(String[] args) {
        TranslateNum_noms46 solution = new TranslateNum_noms46();
        System.out.println(solution.translateNum(506));
    }
}
