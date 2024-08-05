class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //[1,1,2,1,1] k=3
        //  return atMost(nums,k)- atMost(nums,k-1);
        HashMap<Integer,Integer> hmap=new HashMap<>();
        hmap.put(0,1);
        int index=0;
        int currOddCount=0;
        int count=0;
        while(index<nums.length){
            if(nums[index]%2!=0){
                currOddCount++;
            }
            int complement=currOddCount-k;
            if(hmap.containsKey(complement)){
                count+=hmap.get(complement);
            }
            hmap.put(currOddCount,hmap.getOrDefault(currOddCount,0)+1);
            index++;
        }
        return count;
    }

    static int atMost(int[] nums, int k){
        if(k<0) return 0;
        int left=0;
        int right=0;
        int count=0;
        int currCount=0;
        while(right<nums.length){
            if(nums[right]%2!=0){
                currCount++;
            }
            while(currCount>k && left<=right){
               if(nums[left]%2!=0){
                    currCount--;
                }
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }

}