class Solution {
    public int search(int[] nums, int target) {
        //[-1,0,3,5,9,12]
        //ITERATIVE APPROACH
        // int left=0;
        // int right=nums.length-1;
        // while(left<=right){
        //     int mid=(left+right)/2;
        //     if(nums[mid]==target) return mid;
        //     else if(nums[mid]<target){
        //         left=mid+1;
        //     }
        //     else{
        //         right=mid-1;
        //     }
        // }
        // return -1;


        //RECURSIVE APPROACH
         //[-1,0,3,5,9,12]
      return findElementInArrayUsingRecurion(nums,0,nums.length-1,target);

    }

    static int findElementInArrayUsingRecurion(int nums[],int left,int right,int target){
        if(right<left) return -1;
        int mid=left+(right-left)/2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]<target){
            return findElementInArrayUsingRecurion(nums,mid+1,right,target);
        }else{
            return findElementInArrayUsingRecurion(nums,left,mid-1,target);
        }
    }

}