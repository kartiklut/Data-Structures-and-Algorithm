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
    public void reorderList(ListNode head) {

        //find mid
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reversedHead=reverseList(slow.next);
        //divide the two halves
        slow.next=null;
        ListNode firstHalf=head;
        while(reversedHead!=null){
            ListNode temp1=firstHalf.next;
            firstHalf.next=reversedHead;
            ListNode temp2=reversedHead.next;
            reversedHead.next=temp1;
            firstHalf=temp1;
            reversedHead=temp2;
        }
    }

   public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode headNext=head.next;
        ListNode newHead=reverseList(head.next);
        headNext.next=head;
        head.next=null;
        return newHead;

    }
}