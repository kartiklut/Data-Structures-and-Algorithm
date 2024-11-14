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
        ListNode prev=head;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr;
            //advances curr 
            for(int i=0;i<k-1;i++){
                curr=curr.next;
                if(curr==null){
                    prev.next=temp;
                    return head;
                }
            }
            ListNode currNext=curr.next;
            curr.next=null;
            curr=reverseLL(temp);
            if(head==temp) {
                head=curr;
            }else{
                prev.next=curr;
            }
            prev=temp;
            curr=currNext;
        }
        return head;
    }

    public ListNode reverseLL(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode currNext=null;
        while(curr!=null){
            currNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr=currNext;
        }
        return prev;
    }
}