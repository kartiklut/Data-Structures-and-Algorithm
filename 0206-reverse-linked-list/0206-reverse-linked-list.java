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
        // head = [1,2,3,4,5] 2 1
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode temp = head;
        ListNode front = null;
        while (temp!= null) {
            front = temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}