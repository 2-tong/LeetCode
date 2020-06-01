package xyz.tong2.leetcode.recursion;

public class DecodeString_no394 {
        String unCode;
        int index=0;
        public String decodeString(String s) {
            unCode=s;
            return process();
        }

        String process(){
            StringBuilder sb = new StringBuilder();
            for (; index < unCode.length(); index++) {
                char c = unCode.charAt(index);
                if(c==']')
                    break;
                else if(c>='A')
                    sb.append(c);
                else {
                    StringBuilder number = new StringBuilder();
                    while (unCode.charAt(index) <='9') {
                        number.append(unCode.charAt(index++));
                    }
                    int num = Integer.parseInt(number.toString());
                    index++;
                    String child = process();
                    sb.append(String.valueOf(child).repeat(Math.max(0, num)));
                }
            }
            return sb.toString();
        }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString_no394 solution = new DecodeString_no394();
        System.out.println(solution.decodeString(s));
    }
}
