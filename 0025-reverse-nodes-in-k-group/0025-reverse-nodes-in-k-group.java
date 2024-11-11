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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode curr=head;
        ListNode kthNode=head;
        ListNode kthNext=head;
        ListNode prev=head;
        boolean remList=false;
        while(curr!=null){
            kthNode=curr;
            for(int i=0;i<k-1;i++){
                kthNode=kthNode.next;
                if(kthNode==null){
                    remList=true;
                    break;
                }
            }
            if(remList){
                prev.next=curr;
                break;
            }
            kthNext=kthNode.next;
            kthNode.next=null;
            kthNode=reverseLL(curr);
            if(head==curr){
                head=kthNode;
            }
            if(head!=kthNode)
            {
                prev.next=kthNode;
            }
            prev=curr;
            curr=kthNext;
        }
        return head;
    }

    public ListNode reverseLL(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode headNext=head.next;
        ListNode newHead=reverseLL(head.next);
        headNext.next=head;
        head.next=null;
        return newHead;

    }
}