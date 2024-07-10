class Solution {
    public int[] searchRange(int[] nums, int target) {
        //[5,7,7,8,8,10] target =8 OP =[3,4].  [5,7,7,8,8,10] 6 [-1,-1]
        if(nums.length==1 && target==nums[0]) return new int[]{0,0};
        int firstPos=-1;
        int lastPos=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                firstPos=mid;
                right=mid-1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        left=0;
        right=nums.length-1;
        if(firstPos==-1)
            return new int[]{firstPos,lastPos};
        lastPos=nums.length;    
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
                lastPos=mid;
            }else{
                left=mid+1;
            }
        }
        lastPos=lastPos-1;
        return new int[]{firstPos,lastPos};
    }
}