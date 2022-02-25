package xyz.tong2.leetcode.question;

/**
 *
 *
 * @author liwei04
 * @time 2022年02月25日 10:05
 */
public class No537ComplexNumberMultiply {
    public String complexNumberMultiply(String num1, String num2) {
        int[] num1Arr = parse(num1);
        int[] num2Arr = parse(num2);
        int real = num1Arr[0]*num2Arr[0]-num1Arr[1]*num2Arr[1];
        int complex = num1Arr[0]*num2Arr[1]+num1Arr[1]*num2Arr[0];
        return real+"+"+complex+"i";
    }

    private int[] parse(String num){
        int pos = num.indexOf('+');
        int[] res = new int[2];
        res[0] = Integer.parseInt(num.substring(0,pos));
        res[1] = Integer.parseInt(num.substring(pos+1,num.length()-1));
        return res;
    }
}
