class Solution {
    public int singleNonDuplicate(int[] nums) {
        //[1,1,2]
        if(nums.length==1) return nums[0];
        if(nums[0] !=nums[1])  return nums[0];
        if(nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid-1>=0 && mid+1<nums.length && 
                nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                    return nums[mid];
            }
            //even 
            //before breakpoint (even,odd)
            //after break point (odd,even)
            else if(mid%2==0){
                if(mid+1<nums.length && nums[mid]==nums[mid+1]){
                    left=mid+1;
                }else if(mid-1 >=0 && nums[mid]==nums[mid-1]){
                    right=mid-1;
                }
            }else{
                if(mid-1 >=0 && nums[mid]==nums[mid-1]){
                    left=mid+1;
                }else if(mid+1<nums.length && nums[mid]==nums[mid+1]){
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}