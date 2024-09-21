class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int correctPos=nums[i]-1;
            while(nums[i]!=nums[correctPos]){
                correctPos=nums[i]-1;
                int temp=nums[i];
                nums[i]=nums[correctPos];
                nums[correctPos]=temp;
            }

        }
        int dup=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                dup=nums[i];
            }
        }
        return dup;
    }
}