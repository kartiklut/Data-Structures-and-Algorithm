class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        //[0,0,0,0] k=0
        return atMost(nums,goal)- atMost(nums,goal-1);


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


    static int atMost(int[] nums, int goal){
        if(goal<0) return 0;
        int left=0;
        int right=0;
        int count=0;
        int currSum=0;
        while(right<nums.length){
            currSum+=nums[right];
            while(currSum>goal){
                currSum-=nums[left];
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}