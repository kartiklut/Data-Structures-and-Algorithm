class Solution {
    public void sortColors(int[] nums) {
        //[2,0,2,1,1,0]
        // 000000,   11111111,2,0,1,0,1,0,222222222222
        // 0-low-1 ,low-mid-1,mid - high,high+1 - n-1
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high){
           if(nums[mid]==0) {
                swap(nums,mid,low);
                low++;
                mid++;
           }else if(nums[mid]==1){
                mid++;
           }else if(nums[mid]==2){
                swap(nums,mid,high);
                high--;  
           }
        }
    }
    private static void swap(int nums[],int num1,int num2){
        int temp=nums[num2];
        nums[num2]=nums[num1];
        nums[num1]=temp;
    }
}