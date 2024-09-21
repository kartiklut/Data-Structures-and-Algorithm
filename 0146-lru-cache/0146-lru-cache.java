class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}

class LRUCache {

    int capacity;
    HashMap<Integer,Node> hmap=new HashMap<>();
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        head.prev=null;
        tail.next=null;
    }
    
    public int get(int key) {
        //if not exists in hashmap return -1
        if(!hmap.containsKey(key)){
            return -1;
        }
        //delete node from that position
        Node deletedNode=hmap.get(key);
        deleteAndReturnNode(deletedNode);
        //attach to the head to make it recently used
        attachNodeToHead(deletedNode);
        return deletedNode.value;
    }
    
    public void put(int key, int value) {
        if(capacity>0 || hmap.containsKey(key)){
            if(hmap.containsKey(key)){
                //delete node
                Node deletedNode=hmap.get(key);
                deleteAndReturnNode(deletedNode);
                //update value
                 deletedNode.value=value;
                //attach node to head;
                attachNodeToHead(deletedNode);
                //add updated node value to hashmap
                hmap.put(key,deletedNode);
            }else{
                //creta a new node
                Node newNode=new Node(key,value);
                //attach to head
                attachNodeToHead(newNode);
                //put into hashmap
                hmap.put(key,newNode);
                capacity--;
            }
        }else{
            //Delete node from tail
            //delete old node from hashmap
            Node deletedNode=tail.prev;
            deleteAndReturnNode(deletedNode);
            hmap.remove(deletedNode.key);
            //reuse it to form newNode
            deletedNode.key=key;
            deletedNode.value=value;
            //attach to head
            attachNodeToHead(deletedNode);
            //add new node to hashmap
            hmap.put(key,deletedNode);
        }
    }

    public void deleteAndReturnNode(Node myNode){
        Node myNodeNext=myNode.next;
        Node myNodePrev=myNode.prev;
        myNode.next=null;
        myNode.prev=null;
        myNodePrev.next=myNodeNext;
        myNodeNext.prev=myNodePrev;
    }

    public void attachNodeToHead(Node myNode){
        Node headNextRef=head.next;
        head.next=myNode;
        myNode.next=headNextRef;
        headNextRef.prev=myNode;
        myNode.prev=head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */