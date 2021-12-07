package xyz.tong2.leetcode.question;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年08月25日 17:13
 */
public class ABC {

    static long[] lens = {
            3L,
            9L,
            21L,
            45L,
            93L,
            189L,
            381L,
            765L,
            1533L,
            3069L,
            6141L,
            12285L,
            24573L,
            49149L,
            98301L,
            196605L,
            393213L,
            786429L,
            1572861L,
            3145725L,
            6291453L,
            12582909L,
            25165821L,
            50331645L,
            100663293L,
            201326589L,
            402653181L,
            805306365L,
            1610612733L,
            3221225469L,
            6442450941L,
            12884901885L,
            25769803773L,
            51539607549L,
            103079215101L,
            206158430205L,
            412316860413L,
            824633720829L,
            1649267441661L,
            3298534883325L,
            6597069766653L,
            13194139533309L,
            26388279066621L,
            52776558133245L,
            105553116266493L,
            211106232532989L,
            422212465065981L,
            844424930131965L,
            1688849860263933L,
            3377699720527869L
    };

    public static void pos(int deep, long pos, int[] depPos) {
        long start = 0;
        long end = lens[deep] - 1;
        long mid = end / 2;
        if (pos == start) depPos[deep] = 0;
        else if (pos > start && pos < mid) depPos[deep] = 1;
        else if (pos == mid) depPos[deep] = 2;
        else if (pos > mid && pos < end) depPos[deep] = 3;
        else if (pos == end) depPos[deep] = 4;

        pos(deep-1,2,depPos);
    }

    public static void main(String[] args) {
        int[] arr = new int[50];
        pos(49,1234567L,arr);
        System.out.println(arr);
    }
}
