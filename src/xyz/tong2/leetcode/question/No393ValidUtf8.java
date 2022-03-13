package xyz.tong2.leetcode.question;

public class No393ValidUtf8 {
    private static final int[] check1= {0b00,0b11000000,0b11100000,0b11110000,0b11111000};
    private static final int[] check2= {0b00,0b10000000,0b11000000,0b11100000,0b11110000};

    public boolean validUtf8(int[] data) {


        for (int i = 0; i < data.length; ) {
            if (data[i] >= 128) {
                int len = 0;
                for (int j = 2; j < 5; j++) {
                    if ((data[i] & check1[j]) == check2[j])
                        len = j;
                }
                if (len == 0)
                    return false;
                if (i + len > data.length)
                    return false;
                for (int j = 1; j < len; j++) {
                    if ((data[i + j] & check1[1]) != check2[1])
                        return false;
                }
                i += len;
            }
            else
                i++;
        }
        return true;
    }
}
