class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //Optimized Approach - 2 ptr Sliding window
        int left=0;
        int right=0;
        int max_count=Integer.MIN_VALUE;
        int count=0;
        while(right<nums.length){
            count++;
            if(nums[right]==0){
               left=right;
               count=0;
            }
            max_count=Math.max(max_count,count);
            right++;
        }
        return max_count;


        //Brute Force - Find All subarrays and calculate consecutive ones
        // int max_count=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     int count=0;
        //     for(int j=i;j<nums.length;j++){
        //         if(nums[j]==1) count++;
        //         if(nums[j]==0) break;
        //     }
        //     max_count=Math.max(count,max_count);
        // }
        // return max_count;
    }
}