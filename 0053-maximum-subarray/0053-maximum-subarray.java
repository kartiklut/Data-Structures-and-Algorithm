class Solution {
    public int maxSubArray(int[] nums) {
        //[-2,1,-3,4,-1,2,1,-5,4]
        int index=0;
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        int maxEle=Integer.MIN_VALUE;
        while(index<nums.length){
            maxEle=Math.max(maxEle,nums[index]);
            currSum+=nums[index];
            if(currSum<0){
                currSum=0;
            }
            maxSum=Math.max(currSum,maxSum);
            index++;
        }
        if(maxSum<=0)
            return maxEle;
        return maxSum;
    }
}