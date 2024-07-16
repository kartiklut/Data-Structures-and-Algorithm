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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode evenHead=head.next;
        ListNode oddHead=head;
        ListNode curr=evenHead.next;
        ListNode oddPtrMover=oddHead;
        ListNode evenPtrMover=evenHead;
        int count=3;
        while(curr!=null){
            if(count%2==1){
                oddPtrMover.next=curr;
                oddPtrMover=curr;
            }else{
                evenPtrMover.next=curr;
                evenPtrMover=curr;
            }
            count++;
            curr=curr.next;
        }
        oddPtrMover.next=evenHead;
        evenPtrMover.next=null;
        return oddHead;
    }
}

