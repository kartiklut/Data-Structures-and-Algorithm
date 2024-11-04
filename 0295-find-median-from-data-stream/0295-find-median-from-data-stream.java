class MedianFinder {
    int n;
    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;
    public MedianFinder() {
        n=0;
        leftMaxHeap=new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        n++;
        if(leftMaxHeap.size()==0 || num<leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        }else{
            rightMinHeap.add(num);
        }
        if(rightMinHeap.size()>leftMaxHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
        }else if(leftMaxHeap.size()>rightMinHeap.size()+1){
            rightMinHeap.add(leftMaxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(n%2==0){
            int left=leftMaxHeap.peek();
            int right=rightMinHeap.peek();
            return (double)(left+right)/2;
        }
        return (double)leftMaxHeap.peek();
    }
}
    //Brute force Use ArrayList
// ArrayList<Integer> al=new ArrayList<>();
    // public MedianFinder() {

    // }
    
    // public void addNum(int num) {
    //     al.add(num);
    // }
    
    // public double findMedian() {
    //     Collections.sort(al);
    //     if(al.size()==1){
    //         return al.get(0);
    //     }
    //     if(al.size()%2!=0){
    //         int idx1=al.size()/2;
    //         double median=(double)al.get(idx1);
    //         return median;
    //     }
    //     int idx1=al.size()/2;
    //     double median=(double)(al.get(idx1-1)+al.get(idx1))/2;
    //     return median;
    // }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */