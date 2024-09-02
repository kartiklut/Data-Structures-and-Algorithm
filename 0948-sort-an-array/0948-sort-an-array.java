class Solution {
    public int[] sortArray(int[] nums) {
        //[5,2,3,1]
        //5 2
        // len=2
        // ele=nums[2]; //5
            Arrays.sort(nums);
            return nums;
    //    return insertionSortUsingRecursion(nums,nums.length);
    }

    //Recursive
    private int[] insertionSortUsingRecursion(int nums[],int len){
        if(len==1)
            return nums;
        insertionSortUsingRecursion(nums,len-1);
        int ele=nums[len-1];
        int newNums[]=putElementAtCorrectPos(nums,len,ele);
        return nums;
    }

    // 1 2 4 3
    private int[] putElementAtCorrectPos(int nums[],int len,int ele){
        if(len==1) 
            return new int[]{nums[0]};
        int newNums[]=new int[len];
        if(nums[len-1]<=ele){
            
        }else{
            putElementAtCorrectPos(nums,len-1,ele);
        }
        return newNums;
    }

        //Iterative
    // private int[] insertionSortUsingRecursion(int nums[],int len){
    //     if(len==1)
    //         return nums;
    //     insertionSortUsingRecursion(nums,len-1);
    //     int ele=nums[len-1];
    //     for(int i=0;i<len;i++){
    //         if(ele<=nums[i]){
    //             int temp=nums[i];
    //             nums[i]=ele;
    //             ele=temp;
    //         }
    //     }
    //     if(nums[len-1]<=ele){
    //         nums[len-1]=ele;
    //     }
    //     return nums;
    // }
}