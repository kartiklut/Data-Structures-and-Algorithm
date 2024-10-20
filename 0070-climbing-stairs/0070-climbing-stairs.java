class Solution {
    public int climbStairs(int n) {
       int[] cache = new int[n+1];
       Arrays.fill(cache,-1);
       return recursionClimb(n,cache);
        
    }

    public int recursionClimb(int n,int cache[]) {
        if(n<0) return 0;
        if(n==0) return 1;
        if(cache[n]!=-1) return cache[n];
        return cache[n]= recursionClimb(n-2,cache) + recursionClimb(n-1,cache);
    }
}