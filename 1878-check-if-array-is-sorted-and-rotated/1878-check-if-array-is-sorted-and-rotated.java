class Solution {
    public boolean check(int[] nums) {
        int dipCount=0;
        int index=0;
        while(index<nums.length){
            if(index<nums.length-1 && nums[index]>nums[index+1]) {
                dipCount++;
            }
            index++;
        }
        if(nums[nums.length-1]>nums[0]) dipCount++;
        if(dipCount>1) return false;
        return true;
    }
}