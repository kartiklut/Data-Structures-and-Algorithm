/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        //Optimal Solution
        ListNode n1Head=headA;
        ListNode n2Head=headB;
        while(n1Head!=n2Head){
            n1Head=n1Head.next;
            n2Head=n2Head.next;
            if(n1Head==n2Head)
                return n1Head;
            else if(n1Head==null){
                n1Head=headB;
            }else if(n2Head==null){
                n2Head=headA;
            }
        }
        return n1Head;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    //     //Brute Force
    //     ListNode n1Head=headA;
    //     ListNode n2Head=headB;
    //     int n1=0;
    //     int n2=0;
    //     while(n1Head!=null){
    //         n1Head=n1Head.next;
    //         n1++;
    //     }
    //     while(n2Head!=null){
    //         n2Head=n2Head.next;
    //         n2++;
    //     }
    //     n1Head=headA;
    //     n2Head=headB;
    //     if(n1==n2){
    //         //traverse normally
    //         return traverseAndReturnIntersection(n1Head,n2Head,0);
    //     }else if(n1>n2){
    //         //make n1 equal to n2 and then traverse;
    //         return traverseAndReturnIntersection(n1Head,n2Head,n1-n2);
    //     }else{
    //         //make n2 equal to n1 and then traverse
    //         return traverseAndReturnIntersection(n2Head,n1Head,n2-n1);
    //     }
    // }

    //  static ListNode traverseAndReturnIntersection(ListNode largeList,ListNode smallList,int traverseListLen){
    //     while(traverseListLen>0){
    //         largeList=largeList.next;
    //         traverseListLen--;
    //     }
    //     while(largeList!=null && smallList!=null && largeList!=smallList){
    //         smallList=smallList.next;
    //         largeList=largeList.next;
    //     }
    //     return smallList;
     }
}