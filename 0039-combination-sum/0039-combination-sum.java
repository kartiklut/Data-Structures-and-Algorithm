class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Two Approaches - For loop and other one
        return combiSum(candidates,target,0,new ArrayList<>(),new ArrayList<>());
    }

    public List<List<Integer>> combiSum(int candidates[],int target,int index,List<Integer> combSofar,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(combSofar));
            return result;
        }
        if(target<0){
            return result;
        }
        if(index>candidates.length-1){
            return result;
        }

        for(int i=index;i<candidates.length;i++){
            combSofar.add(candidates[i]);
            combiSum(candidates,target-candidates[i],i,combSofar,result);
            combSofar.remove(combSofar.size()-1);
        }
        
        return result;
    }
}