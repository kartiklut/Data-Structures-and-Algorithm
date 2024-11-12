/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2!=null) return list2;
        if(list2==null && list1!=null) return list1;
        if(list1==null && list2==null) return null;
        ListNode result=null;
        if(list1.val<=list2.val){
            result=list1;
            ListNode mergedList=mergeTwoLists(list1.next,list2);
            result.next=mergedList;
        }else{
            result=list2;
            ListNode mergedList=mergeTwoLists(list1,list2.next);
            result.next=mergedList;
        }
        return result;
    }
}