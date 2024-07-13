class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //Optimal Approach(BS)
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
        int left=0;
        int right=nums1.length;
        int leftHalfLen = (nums1.length + nums2.length + 1) / 2;
        while(left<=right){
            int mid1=(left+right)/2; //means take mid1 ele on the left from arr1
            int mid2=leftHalfLen-mid1; //means take rem ele from arr1 on right
            int l1=mid1>0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2=mid2>0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1=mid1<nums1.length ? nums1[mid1] : Integer.MAX_VALUE;
            int r2=mid2<nums2.length ? nums2[mid2] : Integer.MAX_VALUE;
            if(l1<=r2 && l2<=r1){
                if((nums1.length+nums2.length)%2==1)
                    return (double)Math.max(l1,l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }else if(l1>r2) right=mid1-1;
            else if(l2>r1)  left=mid1+1;
        }
        return 0;
















        // nums1 = [1,3], nums2 = [2,7]
        // //BETTER SOlution Without using any extra space
        // int ele1Index=(nums1.length+nums2.length)/2;
        // int ele2Index=(nums1.length+nums2.length)/2+1;
        // double ele1=-1;
        // double ele2=-1;
        // int nums1Ptr=0;
        // int nums2Ptr=0;
        // int count=0;
        // while(nums1Ptr<nums1.length && nums2Ptr<nums2.length){
        //     if(nums1[nums1Ptr]<=nums2[nums2Ptr]){
        //         count++;
        //         if(count==ele1Index) ele1=(double)nums1[nums1Ptr];
        //         if(count==ele2Index) ele2=(double)nums1[nums1Ptr];
        //         nums1Ptr++;
        //     }else if(nums2[nums2Ptr]<nums1[nums1Ptr]){
        //         count++;
        //         if(count==ele1Index) ele1=(double)nums2[nums2Ptr];
        //         if(count==ele2Index) ele2=(double)nums2[nums2Ptr];
        //         nums2Ptr++;
        //     }
        // }
        // while(nums1Ptr<nums1.length){
        //     count++;
        //     if(count==ele1Index) ele1=(double)nums1[nums1Ptr];
        //     if(count==ele2Index) ele2=(double)nums1[nums1Ptr];
        //     nums1Ptr++;
        // }
        // while(nums2Ptr<nums2.length){
        //     count++;
        //     if(count==ele1Index) ele1=(double)nums2[nums2Ptr];
        //     if(count==ele2Index) ele2=(double)nums2[nums2Ptr];
        //     nums2Ptr++;
        // }
        // if((nums1.length+nums2.length)%2==0){
        //     return (double)(ele1+ele2)/2;
        // }
        // return ele2;
    }
}