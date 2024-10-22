class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    
        return getSubsets(nums,new ArrayList<>(),new ArrayList<>(),0);
    }
    
    public List<List<Integer>> getSubsets(int nums[],List<Integer> subsetsSofar,List<List<Integer>> resultAl,int index){
       if(index==nums.length){
            resultAl.add(new ArrayList<>(subsetsSofar));
            return resultAl;
       }
       subsetsSofar.add(nums[index]); // pick
       getSubsets(nums,subsetsSofar,resultAl,index+1);
       subsetsSofar.remove(subsetsSofar.size()-1); //not pick
       getSubsets(nums,subsetsSofar,resultAl,index+1);
       return resultAl;
    }
}