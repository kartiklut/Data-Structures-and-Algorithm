class Solution {

    // In these kind of problem think of BF approach then optimal approach comes in mind v easily
        public int minEatingSpeed(int[] piles, int h) {
                        //BRUTE FORCE
            // [3,6,7,11]
            // h=8
            //find the max cuz i know my ans lies within this range
            // int max=Integer.MIN_VALUE;
            // int ans=Integer.MAX_VALUE;
            // for(int i=0;i<piles.length;i++){
            //     max=Math.max(max,piles[i]);
            // }
            // for(int i=1;i<=max;i++){
            //     //fn to check if my condition is satisfied
            //     //means if she ate bananas within h time
            //     int sumOfBananasAte=calcBananasAte(piles,i);
            //     if(sumOfBananasAte<=h)
            //         ans=Math.min(ans,i);
            // }
            // return ans;
                        //OPTIMAL APPROACH(BINARY SEARCH)
            int left=1;
            int right=Integer.MIN_VALUE;
            int ans=Integer.MAX_VALUE;
            for(int i=0;i<piles.length;i++){
                right=Math.max(right,piles[i]);
            }
            //at the end my left will be pointing at my ans in correct area in case of min
            //my right will be pointing at incorrect area
            while(left<=right){
                int mid=left+(right-left)/2;
                int sumOfBananasAte=calcBananasAte(piles,mid);
                if(sumOfBananasAte<=h){
                    right=mid-1;
                }else{
                    left=mid+1;
                }   
            }
            return left;
        }

        static int calcBananasAte(int piles[],int possibleK){
            int sum=0;
            for(int i=0;i<piles.length;i++){
                sum+=Math.ceil((double)piles[i]/possibleK);
            }
            System.out.println(sum);
            return sum;
        }

        //[805306368,805306368,805306368]
        // 1000000000
}