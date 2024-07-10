class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left=0;  //0 because arr =[2]k =1
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int howManyMissingTillhere=arr[mid]-(mid+1);
            if(howManyMissingTillhere<k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left+k;
    }
}