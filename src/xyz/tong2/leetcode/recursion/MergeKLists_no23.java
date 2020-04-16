package xyz.tong2.leetcode.recursion;
import xyz.tong2.leetcode.recursion.RemoveNthFromEnd_no19.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKLists_no23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k<1)
            return null;

        ListNode[] pNodes = Arrays.copyOf(lists,lists.length);
        int clearCount = 0;

        int min=-1;
        for (int i = 0; i < k; i++) {
            if(pNodes[i]==null)
                clearCount++;
            else if(min==-1||pNodes[i].val<pNodes[min].val)
                min = i;
        }
        if(min==-1)
            return null;

        ListNode head = pNodes[min];
        ListNode p =head;
        pNodes[min]=pNodes[min].next;
        if(pNodes[min]==null)
            clearCount++;

        while (clearCount<k){
            min=-1;
            for (int i = 0; i < k; i++) {
                if(pNodes[i]!=null&&(min==-1||pNodes[i].val<pNodes[min].val))
                    min = i;
            }
            p=p.next=pNodes[min];
            pNodes[min]=pNodes[min].next;
            if(pNodes[min]==null)
                clearCount++;
        }
        return head;
    }

    public static void main(String[] args) {
        MergeKLists_no23 solution = new MergeKLists_no23();
        ListNode[] listNodes = new ListNode[3];
        listNodes[0]=new ListNode("1234");
        listNodes[1]=null;
        listNodes[2]=null;
        System.out.println(solution.mergeKLists(listNodes));
    }
}
