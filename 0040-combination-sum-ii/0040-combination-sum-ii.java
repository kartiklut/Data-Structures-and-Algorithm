class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinations2(candidates,target,0,new ArrayList<>(),new ArrayList<>());
    }

    public List<List<Integer>> combinations2(int candidates[],int target,int startIndex,List<Integer> combSofar,List<List<Integer>> result){
        if(target<0) return result;
        if (target==0){
            result.add(new ArrayList<>(combSofar));
            return result;
        }
        if(startIndex==candidates.length){
            return result;
        }

        for(int i=startIndex;i<candidates.length;i++){
            if(i>startIndex && candidates[i]==candidates[i-1]) continue; //because i have already made combinations from the previous same element
            combSofar.add(candidates[i]);
            combinations2(candidates,target-candidates[i],i+1,combSofar,result);
            combSofar.remove(combSofar.size()-1);
        }
        return result;
    }
}