/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
                //ITERATIVE O(n)
        //Null 1(curr) 2(next) 3 4 5
        // ListNode prev=null;
        // ListNode curr=head;
        // while(curr!=null){
        //     ListNode next=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=next;
        // }
        // return prev;

                //Recursive O(logn)
        if(head==null || head.next==null)
            return head;
        ListNode newHead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}