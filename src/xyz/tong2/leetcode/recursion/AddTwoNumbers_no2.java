package xyz.tong2.leetcode.recursion;


/**
 * No.2
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class AddTwoNumbers_no2 {

    //链表创建函数
    static ListNode creatAListByInt(int x){
        ListNode head = new ListNode(0);
        ListNode p = head;
        int num;
        p.val = x%10;
        x /=10;
        while ((num = x%10) !=0){
            p=p.next = new ListNode(num);
            x /=10;
        }
        return head;
    }

    //链表类
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(long x){
            ListNode p = this;
            long loc;
            this.val = (int) (x%10);
            x /=10;
            while ((loc = x%10) !=0){
                p=p.next = new ListNode((int) loc);
                x /=10;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
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

        //进位标志
        int flag = l1.val + l2.val >= 10?1:0;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {

            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;

            //计算当前位的值
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

        //最后可能进位1
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



