class Solution {
    public int maxProduct(int[] nums) {
        double max_prod=Integer.MIN_VALUE;
        double prefix_prod=1;
        double suffix_prod=1;
        for(int i=0;i<nums.length;i++){
            if(prefix_prod==0) prefix_prod=1; //reset
            if(suffix_prod==0) suffix_prod=1; //reset

            prefix_prod*=nums[i];
            suffix_prod*=nums[nums.length-1-i];
            max_prod=Math.max(max_prod,Math.max(prefix_prod,suffix_prod));
       }
        return (int)max_prod;
    }
}