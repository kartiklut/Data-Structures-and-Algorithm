class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int resArr[]=new int[nums.length-k+1];
        int resIterator=0;
        for(int i=0;i<nums.length;i++){
            while(deque.size()>=1 &&  deque.getFirst()<=i-k && i>=k){
                deque.removeFirst();
            }
            //Monotonic Dec Stack;
            while(deque.size()>=1 && nums[i]>nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i); 
            if(i>=k-1){
                resArr[resIterator]=nums[deque.getFirst()];
                resIterator++;
            }
        }
        return resArr;
    }
}