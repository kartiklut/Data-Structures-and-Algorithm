class Solution {
    public int maxScore(int[] cardPoints, int k) {
      int lsum=0;
      int rsum=0;
      int right=cardPoints.length-1;
      for(int i=0;i<k;i++){
        lsum+=cardPoints[i];
      }
      int maxSum=lsum;
      k--;
      while(k>=0){
        lsum-=cardPoints[k];
        rsum+=cardPoints[right];
        maxSum=Math.max(maxSum,lsum+rsum);
        right--;
        k--;
      }
      return maxSum;
    }
}