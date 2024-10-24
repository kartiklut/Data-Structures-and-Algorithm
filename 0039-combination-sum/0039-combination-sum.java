class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Set<List<Integer>> uniqueComb= combiSum(candidates,target,0,new ArrayList<>(),new HashSet<>());
        return new ArrayList<>(uniqueComb);
    }

    public Set<List<Integer>> combiSum(int candidates[],int target,int index,List<Integer> combSofar,Set<List<Integer>> result){
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

        
        combSofar.add(candidates[index]);
        combiSum(candidates,target-candidates[index],index,combSofar,result);
        combSofar.remove(combSofar.size()-1);
        combiSum(candidates,target,index+1,combSofar,result);
        
        return result;
    }
}