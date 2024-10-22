class Solution {
    public List<List<Integer>> permute(int[] nums) {

        return permutations(nums,new ArrayList<>(),new ArrayList<>());
    }

    public List<List<Integer>> permutations(int[] nums,List<Integer> permSoFar, List<List<Integer>> resultList){
        if(permSoFar.size()==nums.length){
            resultList.add(new ArrayList<>(permSoFar));
            return resultList;
        }
       for(int i=0;i<nums.length;i++){
            if(permSoFar.contains(nums[i])){
                continue;
            }
            permSoFar.add(nums[i]);
            permutations(nums,permSoFar,resultList);
            permSoFar.remove(permSoFar.size()-1);
        }
        return resultList;
    }
}