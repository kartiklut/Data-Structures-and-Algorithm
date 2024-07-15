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
    public boolean isPalindrome(ListNode head) {
        //Using extra space
        // Stack<Integer> stack=new Stack<>();
        // ListNode curr=head;
        // while(curr!=null){
        //     stack.push(curr.val);
        //     curr=curr.next;
        // }
        // curr=head;
        // while(curr!=null){
        //     int val1=stack.pop();
        //     if(val1!=curr.val){
        //         return false;
        //     }
        //     curr=curr.next;
        // }
        // return true;



        //Find middle then rev after middle then compare rev with first half 
        //1 2 3 3 2 1 // 1 2 3 2 1
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHeadOfRevLL=reverseLL(slow.next);
        ListNode start=head;
        while(newHeadOfRevLL!=null){
            if(start.val!=newHeadOfRevLL.val)
                return false;
            start=start.next;
            newHeadOfRevLL=newHeadOfRevLL.next;
        }
        return true;
    }

    ListNode reverseLL(ListNode head){
       if(head==null || head.next==null)
            return head;
        ListNode newHeadNode=reverseLL(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHeadNode;
    }
}