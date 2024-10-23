class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numsList=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            numsList.add(nums[i]);
        }
        Set<List<Integer>> unique=uniquePermutations(numsList,new ArrayList<>(),new HashSet<>());
        return new ArrayList<>(unique);
    }
    Set<List<Integer>> uniquePermutations(List<Integer> numsList,List<Integer> permSofar,Set<List<Integer>> result){
        if(numsList.size()==0){
            result.add(new ArrayList<>(permSofar));
            return result;
        }
        for(Integer nums : numsList){
            permSofar.add(nums);
            List<Integer> slicedList=new ArrayList<>(numsList);
            int index=numsList.indexOf(nums);
            slicedList.remove(index);
            uniquePermutations(slicedList,permSofar,result);
            permSofar.remove(permSofar.size()-1);
        }
        return result;
    }


}