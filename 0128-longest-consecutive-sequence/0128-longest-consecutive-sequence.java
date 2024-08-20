class Solution {
    public int longestConsecutive(int[] nums) {
        // [100,2,99,4,3,1]
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i],i);
        }
        int count=0;
        int maxCount=0;
        int index=0;
        while(index<nums.length){
            if(!hmap.containsKey(nums[index]-1)){
                count=1;
                int nextEle=nums[index]+1;
                while(hmap.containsKey(nextEle)){
                    count++;
                    nextEle++;
                }
            }
            maxCount=Math.max(maxCount,count);
            index++;
        }
        return maxCount;
    }
}