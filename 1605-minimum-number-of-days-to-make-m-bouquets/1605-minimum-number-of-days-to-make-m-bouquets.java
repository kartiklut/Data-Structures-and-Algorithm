class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
                    //BRUTE FORCE
    //   int maxDayPossible=Integer.MIN_VALUE;
    //   int minDay=Integer.MAX_VALUE;
    //   if((long)m*k>bloomDay.length)
    //     return -1;
    //   for(int i=0;i<bloomDay.length;i++){
    //     maxDayPossible=Math.max(maxDayPossible,bloomDay[i]);
    //   }

    //   for(int i=1;i<=maxDayPossible;i++){
    //     int boqFormed=bouquePossibleOnCurrDay(bloomDay,i,k);
    //     if(boqFormed==m){
    //         minDay=Math.min(minDay,i);
    //     }
    //   }
    //   return minDay;
                        //OPTIMAL APPROACH(BINARY SEARCH ON ANSWERS)
      int left=Integer.MAX_VALUE; //min run loop(min->max)
      int right=Integer.MIN_VALUE; //max
      int minDay=Integer.MAX_VALUE;
      if((long)m*k>bloomDay.length)
        return -1;
      for(int i=0;i<bloomDay.length;i++){
        right=Math.max(right,bloomDay[i]);
        left=Math.min(left,bloomDay[i]);
      }

      while(left<=right){
        int mid=left+(right-left)/2;
        int boqFormed=bouquePossibleOnCurrDay(bloomDay,mid,k);
        if(boqFormed>=m){
            right=mid-1;
        }else{
            left=mid+1;
        }
      }
      return left;
    }

    static int bouquePossibleOnCurrDay(int bloomDay[],int currDay,int k){
        int consecutive_flowers=0;
        int boqFormed=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=currDay){
                consecutive_flowers++;
            }
            else{
                consecutive_flowers=0;
            }
            if(consecutive_flowers==k){
                boqFormed++;
                consecutive_flowers=0;
            }
        }
        return boqFormed;
    }
}