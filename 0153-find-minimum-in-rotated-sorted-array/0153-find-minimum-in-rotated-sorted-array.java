class Solution {
    public int findMin(int[] nums) {
        //[3,4,5,1,2].  1
        //[4,5,6,7,0,1,2].  0
        //[11,13,15,17]    11
        int min=Integer.MAX_VALUE;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            //check which half is sorted
            //for left half
            if(nums[mid]>=nums[left]){
                min=Math.min(min,nums[left]);
                left=mid+1;
            }
            //means my right half is sorted
            else if(nums[right]>=nums[mid]){
                min=Math.min(min,nums[mid]);
                right=mid-1;
            }
        }
        return min;

    }
}