class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> uniqueSubsets= getSubsets(nums,0,new ArrayList<>(),new HashSet<>());
        return new ArrayList<>(uniqueSubsets);
    }

    public Set<List<Integer>> getSubsets(int nums[],int index,List<Integer> subsetsSofar,Set<List<Integer>> resultList){
        if(index>nums.length-1){
            resultList.add(new ArrayList<>(subsetsSofar));
            return resultList;
        }
        subsetsSofar.add(nums[index]); //pick
        getSubsets(nums,index+1,subsetsSofar,resultList);
        subsetsSofar.remove(subsetsSofar.size()-1);  //don't pick
        getSubsets(nums,index+1,subsetsSofar,resultList);
        return resultList;
    }
}