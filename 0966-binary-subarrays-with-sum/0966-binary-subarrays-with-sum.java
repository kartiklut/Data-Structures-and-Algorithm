class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        hmap.put(0,1);
        int index=0;
        int count=0;
        int prefSum=0;
        while(index<nums.length){
            prefSum+=nums[index];
            int complement=prefSum-goal;
            if(hmap.containsKey(complement)){
                count+=hmap.get(complement);
            }
            hmap.put(prefSum,hmap.getOrDefault(prefSum,0)+1);
            index++;
        }
        return count;
    }
}