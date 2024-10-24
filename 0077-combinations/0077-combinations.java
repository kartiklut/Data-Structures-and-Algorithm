class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        return combinations(n,k,1, new ArrayList<>(),new ArrayList<>());
    }

    public List<List<Integer>> combinations(int n,int k,int takenN,List<Integer> combSofar,List<List<Integer>> result){
        if(combSofar.size()==k){
            result.add(new ArrayList<>(combSofar));
        }

        for(int i=takenN;i<=n;i++){
            combSofar.add(i);
            combinations(n,k,i+1,combSofar,result);
            combSofar.remove(combSofar.size()-1);
        }
        return result;
    }
}