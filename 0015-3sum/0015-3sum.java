class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resAl=new ArrayList<>();
        Arrays.sort(nums);
        int start=0;
        while(start<nums.length){
            int left=start+1;
            int right=nums.length-1;
            while(left<right){
                int threeSome=nums[start]+nums[left]+nums[right];
                if(threeSome==0){
                    ArrayList<Integer> al=new ArrayList<Integer>(Arrays.asList(nums[start],nums[left],nums[right]));
                    resAl.add(al);
                }
                if(threeSome<=0){
                    //move left for bigger value;
                    left++;
                    while(threeSome<=0 && left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }else{
                    //move right for smaller value;
                    right--;
                    while(threeSome>0 && left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
            }
            start++;
            while(start<nums.length && nums[start]==nums[start-1]){
                start++;
            }
        }
        return resAl;







            //TLE because of extra space
    // List<List<Integer>> resAl=new ArrayList<>();
    //  for(int i=0;i<nums.length;i++){
    //     HashMap<Integer,Integer> hmap=new HashMap<>();
    //     for(int j=i+1;j<nums.length;j++){
    //         int target=0-(nums[i]+nums[j]);
    //         if(hmap.containsKey(target)){
    //             ArrayList<Integer> al=new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],target));
    //             Collections.sort(al);
    //             if(!resAl.contains(al))
    //                 resAl.add(al);
    //         }
    //         hmap.put(nums[j],j);
    //     }
    //  }
    //  return resAl;
    }
}