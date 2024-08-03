class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        //[0,0,0,0] k=0
        //Optimal
        int left=0;
        int right=0;
        int count=0;
        int currSum=0;
        int zerosCount=0;
        while(right<nums.length){
            currSum+=nums[right];
            while(left<right && (nums[left]==0 || currSum>goal)){
                if(nums[left]==0) zerosCount++;
                else zerosCount=0;
                currSum-=nums[left];
                left++;
            }
            if(currSum==goal){
                count=count+1+zerosCount;
            }
            right++;
        }
        return count;


        //Better O(n) and O(goal)
        // HashMap<Integer,Integer> hmap=new HashMap<>();
        // hmap.put(0,1);
        // int index=0;
        // int count=0;
        // int prefSum=0;
        // while(index<nums.length){
        //     prefSum+=nums[index];
        //     int complement=prefSum-goal;
        //     if(hmap.containsKey(complement)){
        //         count+=hmap.get(complement);
        //     }
        //     hmap.put(prefSum,hmap.getOrDefault(prefSum,0)+1);
        //     index++;
        // }
        // return count;
    }
}