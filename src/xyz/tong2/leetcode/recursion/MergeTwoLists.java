package xyz.tong2.leetcode.recursion;

public class MergeTwoLists {

 // Definition for singly-linked list.
  public static class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1==null)
          return l2;
      if(l2==null)
        return l1;
      ListNode result=null;
      if(l1.val<l2.val) {
          result = l1;
          l1=l1.next;
      }
      else {
          result = l2;
          l2=l2.next;
      }
      result.next = mergeTwoLists(l1,l2);
      return result;
    }


}
