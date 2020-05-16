package xyz.tong2.leetcode.recursion;

import xyz.tong2.leetcode.recursion.RemoveNthFromEnd_no19.ListNode;


public class ReverseKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode[] cache = process(head, k);
        ListNode[] cache2;
        ListNode ans = cache[0];
        ListNode p = cache[2];
        while (checkLen(p, k)) {
            cache2 = process(p, k);
            cache[1].next = cache2[0];
            cache = cache2;
            p = cache[2];
        }
        cache[1].next = cache[2];
        return ans;
    }

    private boolean checkLen(ListNode head, int k) {
        while (head != null) {
            head = head.next;
            k--;
            if (k == 0)
                return true;
        }
        return false;
    }

    private ListNode[] process(ListNode head, int k) {
        ListNode[] pointers = new ListNode[3];
        pointers[1] = head;
        ListNode p = head.next, pre = head;
        head.next = null;
        while (k > 1) {
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
            k--;
        }
        pointers[0] = pre;
        pointers[2] = p;
        return pointers;
    }

    public static void main(String[] args) {
        ReverseKGroup_25 solution = new ReverseKGroup_25();
        ListNode list = new ListNode("12345");
        System.out.println(solution.reverseKGroup(list, 3));
    }
}
