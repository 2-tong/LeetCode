package xyz.tong2.leetcode.recursion;

public class RemoveNthFromEnd_no19 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        ListNode(String str) {
            if(str==null||str.length()<1)
                return;
            ListNode p = this;
            this.val=str.charAt(0)-'0';
            for (int i = 1; i < str.length(); i++) {
                p=p.next=new ListNode(str.charAt(i)-'0');
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode p = this.next;
            while (p != null) {
                sb.append("->").append(p.val);
                p=p.next;
            }
            return sb.toString();
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null||head.next==null)
            return null;
        else {
            ListNode tail = head;
            int point=-1;
            ListNode p = head;
            while (p!=null) {
                p = p.next;
                if(point++>=n)
                    tail=tail.next;
            }
            if(point==n-1)
                return head.next;
            else {
                tail.next=tail.next.next;
                return head;
            }
        }
    }

    public static void main(String[] args) {
        RemoveNthFromEnd_no19 solution = new RemoveNthFromEnd_no19();
        ListNode n = new ListNode("1");
        System.out.println(solution.removeNthFromEnd(n,1));
    }
}
