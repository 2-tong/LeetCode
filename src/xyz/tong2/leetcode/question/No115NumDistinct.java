package xyz.tong2.leetcode.question;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 *   给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围
 * @author liwei
 */
public class No115NumDistinct {
    /**
     * 思路,使用数组存储t0~ti字符串出现次数。遍历s字符串,动态更新数组的值。
     * 举例子1：s:babgbag,t:bag。
     *  char bag
     * :b    100
     * :a    110
     * :b    210
     * :g    211
     * :b    311
     * :a    341
     * :g    345
     * 举例子2：s:rabbbit,rabbit
     *  char rabbit
     * :r    100000
     * :a    110000
     * :b    111000
     * :b    112100
     * :b    113300
     * :i    113330
     * :t    113333
     */
    public int numDistinct(String s, String t) {
        // 边界情况
        if(t.length()>s.length())
            return 0;
        if(t.length()==s.length()&&t.equals(s))
            return 1;

        /*
         * result[i]表示目前为止,组成t0~ti字符串的数量。
         * 例如t为bag时，result[1]表示ba字符串出现个数。
         */
        int[] result = new int[t.length()];
        //主循环遍历s
        for (int i = 0; i < s.length(); i++) {
            //当前s的字符
            char s_char = s.charAt(i);
            //临时存储未改变前的个数，用于子循环
            int lastPreNum = result[0];
            //先处理j=0情况，下面循环可以少些判断
            if(s_char == t.charAt(0))
                result[0]++;

            for (int j = 1; j < t.length(); j++) {
                int tmp = result[j];
                //如果上一位为0，则后面不必要再循环。
                if(result[j-1]==0)
                    break;
                //关键！当前s字符等于该位t字符的时候
                //那么(t0~tj)字符串出现的次数就等于(t0~tj)已经出现次数+(t0~t[j-1])出现次数。
                if(s_char == t.charAt(j))
                    result[j]+=lastPreNum;
                lastPreNum = tmp;//存储上次大循环(t0~t[j-1])出现次数。
            }
        }
        return result[t.length()-1];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        No115NumDistinct solution = new No115NumDistinct();
        System.out.println(solution.numDistinct(s,t));
    }
}
