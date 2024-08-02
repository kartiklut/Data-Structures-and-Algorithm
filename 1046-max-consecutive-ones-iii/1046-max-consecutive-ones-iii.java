class Solution {
    public int longestOnes(int[] nums, int k) {
        //[1,1,1,0,0,0,1,1,1,1,0], k = 2
        //[0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
        int left=0;
        int right=0;
        int max_len=0;
        int currK=k;
        while(right<nums.length){
            if(nums[right]==0){
                currK--;
            }
            if(currK<0){
                while(left<=right && nums[left]!=0){
                    left++;
                }
                left++;
                currK++;
            }
            max_len=Math.max(max_len,right-left+1);
            right++;
        }
        return max_len;
    }
}