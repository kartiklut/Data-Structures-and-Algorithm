class Solution {
    public int removeDuplicates(int[] nums) {
        //[1,1,2]
        int left=0;
        int right=0;
        int k=0;
        while(right<nums.length){
            while(right<nums.length-1 && nums[right]==nums[right+1]){
                right++;
            }
            nums[left]=nums[right];
            k++;
            left++;
            right++;
        }
        return k;
    }
}