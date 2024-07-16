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
    public ListNode deleteMiddle(ListNode head) {
        //[1,3,4,7,1,2,6]
        if(head.next==null)  return null;
        ListNode slow=head;
        ListNode fast=head.next.next;
        // int n=2;
        // while(fast.next!=null && n>0){
        //     fast=fast.next;
        //     n--;
        // }
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}