class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1;
        int right=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            right=Math.max(right,nums[i]);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(doIHaveValueNearThreshold(nums,threshold,mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    static boolean doIHaveValueNearThreshold(int nums[],int threshold,int currDiv){
        int sumOfDiv=0;
        for(int i=0;i<nums.length;i++){
            sumOfDiv+=Math.ceil((double)nums[i]/currDiv);
        }
        if(sumOfDiv<=threshold)
            return true;
        return false;
    }
}