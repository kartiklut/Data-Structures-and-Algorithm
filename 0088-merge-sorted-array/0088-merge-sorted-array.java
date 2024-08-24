class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==1 && n==0) return;
        if(m==0 && n==1){
            nums1[0]=nums2[0];
            return;
        } 
        int left=m-1;
        int mid=m+n-1;
        int end=n-1;
        while(end>=0){
            if(left>=0 && nums1[left]>nums2[end]){
                nums1[mid]=nums1[left];
                left--;
            }else{
                nums1[mid]=nums2[end];
                end--;
            }
            mid--;
        }
    }
}