package xyz.tong2.leetcode.question;

/**
 * <a href="https://leetcode-cn.com/problems/additive-number/">累加数</a>
 *
 * @author liwei04
 * @time 2022年01月10日 10:04
 */
public class No306IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        char[] arr = num.toCharArray();
        if(arr.length<3)
            return false;
        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = i+1; j < num.length() ; j++) {
                if(check(0,i,j,arr))
                    return true;
            }
        }
        return false;
    }

    private boolean check(int start,int mid,int end,char[] arr){
        String[] nums = new String[2];
        if((arr[start]=='0'&&mid-start>1)||(arr[mid]=='0'&&end-mid>1))
            return false;
        nums[0] = new String(arr,start,mid-start);
        nums[1] = new String(arr,mid,end-mid);
        String sum = add(nums[0],nums[1]);
        if(arr.length-end<sum.length())
            return false;
        for (int i = 0; i < sum.length(); i++) {
            if(arr[end+i]!=sum.charAt(i))
                return false;
        }
        if (arr.length-end==sum.length())
            return true;
        return check(mid,end,end+sum.length(),arr);
    }

    private String add(String a,String b){
        int carry = 0;
        char[] arr = new char[Math.max(a.length(),b.length())+1];
        for (int i = 0; i < arr.length; i++) {
            int posA = i<a.length()?a.charAt(a.length()-1-i)-'0':0;
            int posB = i<b.length()?b.charAt(b.length()-1-i)-'0':0;
            int add = posA+posB+carry;
            arr[arr.length-1-i] = (char) ('0'+add%10);
            carry = add>9?1:0;
        }
        return arr[0]=='0'?new String(arr,1,arr.length-1):new String(arr);
    }

    public static void main(String[] args) {
        No306IsAdditiveNumber additiveNumber = new No306IsAdditiveNumber();
        System.out.println(additiveNumber.isAdditiveNumber("10112"));
    }
}
