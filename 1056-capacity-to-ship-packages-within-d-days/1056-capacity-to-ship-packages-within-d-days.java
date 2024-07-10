class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=Integer.MIN_VALUE;
        int right=0;
        for(int i=0;i<weights.length;i++){
            right+=weights[i];
            left=Math.max(left,weights[i]);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canIShipAllPackagesWithCurrWeight(weights,days,mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    static boolean canIShipAllPackagesWithCurrWeight(int weights[],int days,int currWeight){
        int packagesWeight=0;
        int totalDays=1;
        for(int i=0;i<weights.length;i++){
            packagesWeight+=weights[i];
            if(packagesWeight>currWeight){
                totalDays+=Math.ceil((double)weights[i]/currWeight);
                packagesWeight=weights[i];
            }
        }
        if(totalDays<=days)
            return true;
        return false;
    }
}