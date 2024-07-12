class Solution {
    public int findKthPositive(int[] arr, int k) {
        //[2,3,4,7,11], k = 5
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int howManyMissingTillHere=arr[mid]-(mid+1);
            if(howManyMissingTillHere<k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        // int tillHereHowManyMissing=arr[right]-(right+1);
        // //i am looking for k-tillHereHowManyMissing
        // arr[right]+k-(arr[right]-(right+1));
        // k+right+1;
        // k+left
        return k+left; //or k+right+1;
    }
}