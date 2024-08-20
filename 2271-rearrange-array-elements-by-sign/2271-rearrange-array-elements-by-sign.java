class Solution {
    public int[] rearrangeArray(int[] nums) {
        int negativeIndex=-1;
        int positiveIndex=-1;
        int index=0;
        int resArr[]=new int[nums.length];
        int arrIterator=0;
        while(index<nums.length){
            if(nums[index]>0){
                positiveIndex=index;
                break;
            }
             index++;   
        }
        index=0;
        while(index<nums.length){
            if(nums[index]<0){
                negativeIndex=index;
                break;
            }
             index++;   
        }
        while(positiveIndex<nums.length && negativeIndex<nums.length){
            resArr[arrIterator]=nums[positiveIndex];
            arrIterator++;
            positiveIndex++;
            resArr[arrIterator]=nums[negativeIndex];
            arrIterator++;
            negativeIndex++;
            while(positiveIndex<nums.length){
                if(nums[positiveIndex]>0){
                    break;
                }  
                positiveIndex++;
            }
            while(negativeIndex<nums.length){
                if(nums[negativeIndex]<0){
                    break;
                }  
                negativeIndex++;
            }
        }
        return resArr;
    }
}