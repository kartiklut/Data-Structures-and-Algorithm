class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultAl=new ArrayList<>();
        Arrays.sort(nums);
        //[-4,-1,-1,0,1,2]
    //i will be contsant j will be in mid and k will be at last for every i complete j and k to check
    //if a[i]+a[j]+a[k]==0
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    resultAl.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    j++;
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0){
                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    j++;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    k--;
                }
            }
        }
        return resultAl;
    }
}