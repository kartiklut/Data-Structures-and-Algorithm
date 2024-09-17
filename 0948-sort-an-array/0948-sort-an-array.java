class Solution {
    public int[] sortArray(int[] nums) {
         sort(nums,0,nums.length-1);
         return nums;
    }

   static void sort(int nums[],int left,int right){
        if(right<=left) return;
        int mid=(right+left)/2;
        sort(nums,left,mid);
        sort(nums,mid+1,right);
        mergeLeftRight(nums,left,right,mid);
    }

   static void mergeLeftRight(int nums[],int left,int right,int mid){
        int temp[]=new int[right-left+1];
        int l=left;
        int r=mid+1;
        int index=0;
        while(l<=mid && r<=right){
            if(nums[l]<=nums[r]){
                temp[index]=nums[l];
                l++;
                index++;
            }else if(nums[r]<nums[l]){
                temp[index]=nums[r];
                r++;
                index++;
            }
        }
        while(l<=mid){
            temp[index]=nums[l];
            l++;
            index++;
        }
        while(r<=right){
            temp[index]=nums[r];
            r++;
            index++;
        }
        for(int i=left;i<=right;i++){
            nums[i]=temp[i-left];
        }
    }
}