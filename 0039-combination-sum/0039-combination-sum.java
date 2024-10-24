class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
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

        
        combSofar.add(candidates[index]);
        combiSum(candidates,target-candidates[index],index,combSofar,result);
        combSofar.remove(combSofar.size()-1);
        combiSum(candidates,target,index+1,combSofar,result);
        
        return result;
    }
}