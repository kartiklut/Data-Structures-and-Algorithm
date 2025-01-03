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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode carry=new ListNode(0);
        ListNode resultNode=new ListNode(-1);
        ListNode resIterator=resultNode;
        while(l1!=null && l2!=null){
            int currSum=l1.val+l2.val+carry.val;
            resIterator = checkAndAddNode(currSum, carry, resIterator);
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int currSum=l1.val+carry.val;
            resIterator = checkAndAddNode(currSum, carry, resIterator);
            l1=l1.next;
        }
        while(l2!=null){
            int currSum=l2.val+carry.val;
            resIterator = checkAndAddNode(currSum, carry, resIterator);
            l2=l2.next;
        }
        if(carry.val==1){
            resIterator.next=new ListNode(1);
            resIterator=resIterator.next;
        }
        return resultNode.next;
    }

    public ListNode checkAndAddNode(int currSum,ListNode carry,ListNode resIterator){
            ListNode currSumNode;
            if(currSum>9){
                currSum=currSum%10;
                currSumNode=new ListNode(currSum);
                carry.val=1;
            }else{
                currSumNode=new ListNode(currSum);
                carry.val=0;
            }
            resIterator.next=currSumNode;
            return currSumNode;
    }
}