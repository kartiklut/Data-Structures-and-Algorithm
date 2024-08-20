class Solution {
    public int maxProfit(int[] prices) {
        int curr_small=prices[0];
        int curr_largest=prices[0];
        int max_profit=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
           if(prices[i]<curr_small){
                curr_small=prices[i];
                curr_largest=prices[i];
           }if(prices[i]>curr_largest){
                curr_largest=prices[i];
           }
           max_profit=Math.max(max_profit,curr_largest-curr_small);
        }
        if(max_profit<0)
            return 0;
        return max_profit;
    }
}