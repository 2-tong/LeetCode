package xyz.tong2.leetcode.question;

import xyz.tong2.leetcode.util.ListNode;

/**
 * TODO
 *
 * @author liwei04
 * @time 2021年03月18日 09:35
 */
public class No92ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head;
        ListNode last = null;
        while (left > 1){
            last = cur;
            cur = cur.next;
            left--;
            right--;
        }
        ListNode loc = last;
        ListNode lastLoc = cur;
        ListNode next = cur.next;
        while (right > 1){
            cur.next = last;
            last = cur;
            cur = next;
            next = cur.next;
            right --;
        }
        cur.next = last;
        last = cur;
        cur = next;
        lastLoc.next = cur;
        if(loc==null)
            return last;
        loc.next = last;
        return head;
    }
}
