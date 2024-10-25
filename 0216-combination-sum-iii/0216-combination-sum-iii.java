class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinations3(k,n,1,new ArrayList<Integer>(),new ArrayList<>());
    }

    public List<List<Integer>> combinations3(int k,int target,int startIndex,List<Integer> combSofar,List<List<Integer>> result){
        if(target==0){
            if(combSofar.size()==k){
                result.add(new ArrayList<>(combSofar));
            }
            return result;
        }
        if(target<0) return result;
        if(startIndex>9) return result;

        for(int i=startIndex;i<=9;i++){
            combSofar.add(i);
            combinations3(k,target-i,i+1,combSofar,result);
            combSofar.remove(combSofar.size()-1);
        }
        return result;
    }
}