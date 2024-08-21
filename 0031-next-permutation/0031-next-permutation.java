class Solution {
    public void nextPermutation(int[] nums) {
        int breakPointIndex=nums.length-1;
        int smallestIndex=-1;
        int smallestEle=-1;
        while(breakPointIndex>0 && nums[breakPointIndex-1]>=nums[breakPointIndex]){
            breakPointIndex--;
        }
        if(breakPointIndex==0){
            reverseArray(nums,0,nums.length-1);
            return;
        }
        smallestIndex=breakPointIndex;
        for(int i=nums.length-1;i>=breakPointIndex;i--){
            if(nums[i]>nums[breakPointIndex-1]){
                smallestIndex=i;
                break;
            }
        }
        swap(nums,breakPointIndex-1,smallestIndex);
        reverseArray(nums,breakPointIndex,nums.length-1);
    }

    private static void reverseArray(int nums[],int startIndex,int endIndex){
        while(startIndex<=endIndex){
            swap(nums,startIndex,endIndex);
            startIndex++;
            endIndex--;
        }
    }

    private static void swap(int nums[],int index1,int index2){
        int temp=nums[index2];
        nums[index2]=nums[index1];
        nums[index1]=temp;
    }

}