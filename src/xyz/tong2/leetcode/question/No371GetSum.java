package xyz.tong2.leetcode.question;

/**
 * 给你两个整数 a 和 b ，不使用 运算符+ 和-，计算并返回两整数之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 *
 * 输入：a = 2, b = 3
 * 输出：5
 *
 * 提示：
 *
 * -1000 <= a, b <= 1000
 *
 * @author liwei04
 * @time 2021年09月26日 14:07
 */
public class No371GetSum {
    public int getSum(int a, int b) {
        return b==0?a:getSum(a^b,(a&b)<<1);
    }

    public static void main(String[] args) {
        No371GetSum getSum = new No371GetSum();
        System.out.println(getSum.getSum(-23,323));
    }
}
