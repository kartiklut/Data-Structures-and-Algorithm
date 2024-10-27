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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node!=null){
                minHeap.add(node);
            }
           
        }
        ListNode mergedHead=new ListNode(-1);
        ListNode iterator=mergedHead;
        //run the process till you have elements in the pq
        while(minHeap.size()>0){
            ListNode minNode=minHeap.poll();
            iterator.next=minNode;
            iterator=minNode;

            //means there are some more nodes in the current list so add them in pq
            if(minNode.next!=null){
                minHeap.add(minNode.next);
            }
        }

        return mergedHead.next;



    }
}