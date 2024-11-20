class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // [1,3,-1,-3,5,3,6,7]

        Deque<Integer> deque=new ArrayDeque<>();
        int resArr[]=new int[nums.length-k+1];
        int indexIterator=0;
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty() && deque.getFirst()<=i-k && i>=k-1){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i])
            {
                deque.removeLast();
            }
            deque.addLast(i);
            if(i>=k-1){
                resArr[indexIterator]=nums[deque.getFirst()];
                indexIterator++;
            }
        }
        return resArr;

    }
}