class Solution {
    public int findPeakElement(int[] nums) {
        int left=1;
        int right=nums.length-2;
        int peak=-1;
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]){
            peak=0;
        }else if(nums[nums.length-1]>nums[nums.length-2]){
            peak=nums.length-1;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                peak=mid;
                break;
            }else if(nums[mid+1]>=nums[mid]){
                left=mid+1;
            }else if(nums[mid-1]>=nums[mid]){
                right=mid-1;
            }
        }
        return peak;
    }
}