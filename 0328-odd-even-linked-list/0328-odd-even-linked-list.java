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
        if(head==null) return head;
        ListNode oddHead=head;
        ListNode oddIterator=oddHead;
        ListNode evenHead=head.next;
        ListNode evenIterator=evenHead;
        while(oddIterator.next!=null && evenIterator.next!=null){
            oddIterator.next=oddIterator.next.next;
            oddIterator=oddIterator.next;
            evenIterator.next=evenIterator.next.next;
            evenIterator=evenIterator.next;
        }
        oddIterator.next=evenHead;
        return oddHead;
    }
}