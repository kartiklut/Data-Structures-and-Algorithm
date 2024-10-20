class Solution {
    public int uniquePaths(int m, int n) {
        int cache[][]=new int[m+1][n+1];
        for(int[] arr : cache){
            Arrays.fill(arr,-1);
        }
        return getUniquePaths(0,0,m,n,cache);
    }

    public int getUniquePaths(int sourceM,int sourceN,int m, int n,int cache[][]){
        if(sourceM>m-1 || sourceN>n-1) return 0;
        if(sourceM==m-1 && sourceN==n-1) return 1;
        if(cache[sourceM][sourceN]!=-1) return cache[sourceM][sourceN];
        return cache[sourceM][sourceN]=getUniquePaths(sourceM+1,sourceN,m,n,cache)+getUniquePaths(sourceM,sourceN+1,m,n,cache); 
    }

}