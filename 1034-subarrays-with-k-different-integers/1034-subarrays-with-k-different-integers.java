class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        //[1,2,1,3,4] k=3

        //1+2+3+4+3=13
        //1+2+3+2+2=10  ans=13-10=3
        return atMost(nums,k)-atMost(nums,k-1);
    }
    // k=3
// {1,1},{3,1},{4,1}
// cnt=1+2+3+4+3
    private int atMost(int nums[],int k){
        if(k<0) return 0;
        int left=0;
        int right=0;
        int count=0;
        HashMap<Integer,Integer> hmap=new HashMap<>();
        while(right<nums.length){
            hmap.put(nums[right],hmap.getOrDefault(nums[right],0)+1);
            while(hmap.size()>k && left<=right){
                hmap.put(nums[left],hmap.get(nums[left])-1);
                if(hmap.get(nums[left])==0){
                    hmap.remove(nums[left]);
                }
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}