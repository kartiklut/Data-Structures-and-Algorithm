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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode curr=head;
        ListNode prev=head;
        while(curr!=null){
            if(prev.val==curr.val){
                curr=curr.next;
            }else{
                prev.next=curr;
                prev=curr;
                curr=curr.next;
            }
        }
        prev.next=null;
        return head;
    }
}