package xyz.tong2.leetcode.recursion;

public class AddTwoNumbers_no2 {
    static ListNode creatAListByInt(int x){
        ListNode head = new ListNode(0);
        ListNode p = head;
        int num = 0;
        p.val = x%10;
        x /=10;
        while ((num = x%10) !=0){
            p=p.next = new ListNode((int) num);
            x /=10;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(long x){
            ListNode p = this;
            long loc = 0;
            this.val = (int) (x%10);
            x /=10;
            while ((loc = x%10) !=0){
                p=p.next = new ListNode((int) loc);
                x /=10;
            }
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append(val);
            ListNode p =next;
            while (p!=null) {
                sb.append(p.val);
                p=p.next;
            }
            return sb.reverse().toString();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode((l1.val + l2.val) % 10);
        ListNode p = ans;
        int flag = l1.val + l2.val >= 10?1:0;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {

            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            p = p.next = new ListNode((l1val + l2val + flag) % 10);
            if (l1val+ l2val + flag >= 10)
                flag = 1;
            else
                flag = 0;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if(flag==1)
            p.next=new ListNode(1);
        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = creatAListByInt(223);
        ListNode l2 = creatAListByInt(225);
        AddTwoNumbers_no2 slou = new AddTwoNumbers_no2();
        ListNode ans = slou.addTwoNumbers(l1,l2);
        System.out.println(ans);
    }
}



