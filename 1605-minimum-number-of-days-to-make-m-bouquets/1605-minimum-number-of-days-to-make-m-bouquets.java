class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k) return -1;
        int minDays=-1;
        int left=Integer.MAX_VALUE;
        int right=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
           left=Math.min(left,bloomDay[i]);
           right=Math.max(right,bloomDay[i]);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canIFormBouquetWithCurrDay(bloomDay,mid,m,k)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    static boolean canIFormBouquetWithCurrDay(int bloomDay[],int currDay,int bouquet,int flowers){
        int boqFormed=0;
        int totalFlowers=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=currDay){
                totalFlowers++;
            }
            else if(bloomDay[i]>currDay){
                totalFlowers=0;
            }
            if(totalFlowers==flowers){
                boqFormed++;
                totalFlowers=0;
            }
            if(boqFormed==bouquet)
                return true;
        }
        return false;
    }
}