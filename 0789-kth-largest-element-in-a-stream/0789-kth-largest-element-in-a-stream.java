class KthLargest {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    int globalK;
    public KthLargest(int k, int[] nums) {
        globalK=k;
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size()>0 && minHeap.peek()>=val){
            if(minHeap.size()>globalK){
                return minHeap.peek();      
            }
        } 
        minHeap.add(val);
        if(minHeap.size()>globalK) minHeap.poll();
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */