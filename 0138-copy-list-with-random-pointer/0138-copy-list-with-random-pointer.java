/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        //create deep copy and add to its original's adjacent
        Node curr=head;
        while(curr!=null){
            //create deep copy
            Node deepCopy=new Node(curr.val);
            Node temp=curr.next;
            curr.next=deepCopy;
            deepCopy.next=temp;
            curr=curr.next.next;
        }
        //fill the random pointers
        Node newCurr=head.next;
        curr=head;
        while(curr!=null && curr.next!=null){
            newCurr=curr.next;
            if(curr.random==null){
                curr=curr.next.next;
                continue;
            }
            newCurr.random=curr.random.next;
            curr=curr.next.next;
        }
        //create newHead;
        Node newHead=head.next;
        newCurr=newHead;
        curr=head;
        while(newCurr!=null && curr!=null){
            curr.next=curr.next!=null ? curr.next.next : null;
            curr=curr.next;
            newCurr.next=newCurr.next!=null ? newCurr.next.next : null;
            newCurr=newCurr.next;
        }
        return newHead;

    }

            //O(N) space
    // public Node copyRandomList(Node head) {
    //     Node curr=head;
    //     Node newHead=null;
    //     Node newCurr=null;
    //     Node prev=null;
    //     HashMap<Node,Node> hmap=new HashMap<>(); //<origNode,deepCopyNode>
    //     while(curr!=null){
    //         //create deep copy
    //         Node deepCopy=new Node(curr.val);
    //         hmap.put(curr,deepCopy);
    //         newCurr=deepCopy;
    //         if(newHead==null){
    //             newHead=deepCopy;
    //             prev=newHead;
    //         }else{
    //             prev.next=deepCopy;
    //             prev=prev.next;
    //         }
    //         curr=curr.next;
    //     }
    //     //add random
    //     curr=head;
    //     newCurr=newHead;
    //     while(curr!=null){
    //         if(curr.random!=null){
    //             newCurr.random=hmap.get(curr.random);
    //         }
    //         curr=curr.next;
    //         newCurr=newCurr.next;
    //     }
    //     return newHead;
    // }
}