class Solution {
    public int splitArray(int[] nums, int k) {
       int left=Integer.MIN_VALUE;
       int right=0;
       for(int i=0;i<nums.length;i++){
           left=Math.max(left, nums[i]);
           right+=nums[i];
       }
       while(left<=right){
           int mid=left+(right-left)/2;
           if(canISplitArray(nums,mid,k)){
               right=mid-1; 
           }
           else{
               left=mid+1;
           }
       }
       return left;
    }

    static boolean canISplitArray(int[] nums,int currPossibleSplit,int totalNoOfSplits){
        int countSplittedSubarrays=1;
        int lastSplitArray=nums[0];
        for(int i=1;i<nums.length;i++){
            lastSplitArray+=nums[i];
            if(lastSplitArray>currPossibleSplit){
                countSplittedSubarrays+=Math.ceil((double)nums[i]/currPossibleSplit);
                lastSplitArray=nums[i];
            }
            if(countSplittedSubarrays>totalNoOfSplits)
                return false;
        }
        return true;
    }  
}