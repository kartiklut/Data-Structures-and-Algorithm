class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       HashMap<Integer,Integer> hmap=new HashMap<>();
       hmap.put(-0,1);
       int index=0;
       int prefSum=0;
       int count=0;
       while(index<nums.length){
            prefSum+=nums[index];
            int rem=prefSum%k;
            if(rem<0){
                rem+=k;
            }
            if(hmap.containsKey(rem)){
                count+=hmap.get(rem);
            }
            hmap.put(rem,hmap.getOrDefault(rem,0)+1);
            index++;
       }
       return count;
    }
}