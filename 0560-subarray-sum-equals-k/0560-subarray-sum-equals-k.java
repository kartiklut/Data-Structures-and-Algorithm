class Solution {
    public int subarraySum(int[] nums, int k) {
        //[1,2,3] k=3
        HashMap<Integer,Integer> hmap=new HashMap<>();
        int prefSum=0;
        int count=0;
        int index=0;
        hmap.put(0,1);
        while(index<nums.length){
            prefSum+=nums[index];
            int complement=prefSum-k;
            if(hmap.containsKey(complement)){
                count+=hmap.get(complement);
            }
            hmap.put(prefSum,hmap.getOrDefault(prefSum,0)+1);
            index++;
        }
        return count;
    }
}