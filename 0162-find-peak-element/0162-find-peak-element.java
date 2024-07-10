class Solution {
    public int findPeakElement(int[] nums) {
        int left=1;
        int right=nums.length-2;
        int index=-1;
        if(nums[0]>nums[nums.length-1])
            index=0;
        else
            index=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                index=mid;
                break;
            }
            if(nums[mid+1]>nums[mid])
                left=mid+1;
            else if(nums[mid-1]>nums[mid])
                right=mid-1;  
        }
        return index;
    }
}