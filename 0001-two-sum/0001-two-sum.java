class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 0 3 0 target =0
        HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
        int index1=-1;
        int index2=-1;
        int idx=0;
        int currSum=0;
        while(idx<nums.length){
            int complement=target-nums[idx];
            if(hmap.containsKey(complement) && idx!=hmap.get(complement)){
                index1=hmap.get(complement);
                index2=idx;
                break;
            }else{
                hmap.put(nums[idx],idx);
            }
            idx++;
        }
        return new int[]{index1,index2};
    }
}