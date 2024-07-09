/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // if(head==null || head.next==null) return null;
        // List<ListNode> list=new ArrayList<>();
        // ListNode curr=head;
        // list.add(curr);
        // while(curr.next!=null){
        //     curr=curr.next;
        //     int index=list.indexOf(curr);
        //     if(index>=0){
        //         return list.get(index);
        //     }
        //     list.add(curr);
        // }
        // return null;

        if(head==null || head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }
        if(slow!=fast)
            return null;
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;//slow/fast
    }
}