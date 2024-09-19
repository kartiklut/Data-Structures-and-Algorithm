class Solution {
    public int trap(int[] height) {
                //USING STACKS
        int left=0;
        int right=height.length-1;
        int lmax=0;
        int rmax=0;
        int count=0;
        while(right>=left){
            if(height[left]<=height[right]){
                lmax=Math.max(lmax,height[left]);
                count+=lmax-height[left];
                left++;
            }else if(height[right]<height[left]){
                rmax=Math.max(rmax,height[right]);
                count+=rmax-height[right];
                right--;
            }
        }
        return count;
        


        //          USING PREFMAX & SUFFMAX
        //if min(leftMax,rightMax)>arr[i] then only proceed

        // int total=0;
        // int leftMax=-1;
        // // int prefMax[]=new int[height.length];
        // // prefMax[0]=height[0];
        // // for(int i=1;i<height.length;i++){
        // //     prefMax[i]=Math.max(prefMax[i-1],height[i]);
        // // }
        // int suffMax[]=new int[height.length];
        // suffMax[height.length-1]=height[height.length-1];
        // for(int i=height.length-2;i>=0;i--){
        //     suffMax[i]=Math.max(suffMax[i+1],height[i]);
        // }
        // for(int i=0;i<height.length;i++){
        //     //if min(leftMax,rightMax)>arr[i] then only proceed
        //     leftMax=Math.max(leftMax,height[i]);
        //     int rightMax=suffMax[i];
        //     int minOfLeftRight=Math.min(leftMax,rightMax);
        //     if(minOfLeftRight>height[i]){
        //         total+=minOfLeftRight-height[i];
        //     }
        // }
        // return total;
    }
}