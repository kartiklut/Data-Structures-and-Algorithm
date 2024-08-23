class Solution {
    public int majorityElement(int[] nums) {
        //sort the array
        // Arrays.sort(nums);
        // int curr_ele=nums[0];
        // int count=0;
        // int result_element=nums[0];
        // int index=0;
        // int max_count=Integer.MIN_VALUE;
        // while(index<nums.length){
        //     if(curr_ele!=nums[index]){
        //         count=0;
        //         curr_ele=nums[index];
        //     }
        //     if(curr_ele==nums[index])
        //         count++;
        //     if(count>max_count){
        //         max_count=count;
        //         result_element=curr_ele;
        //     }
        //     index++;
        // }
        // return result_element;

        //Approach 2
        //Moore's Voting Algorithm
        int majority_ele=nums[0];
        int count=1;
        int index=1;
        while(index<nums.length){
            if(count==0){
                majority_ele=nums[index];
            }
            if(nums[index]==majority_ele)
                count++;
            if(nums[index]!=majority_ele)
                count--;
            index++;
        }
        //now check if the majority_ele present in the list is actually occured>n/2 times or not
        count=0; //reuse same variable again
        for(int i=0;i<nums.length;i++){
            if(count>(nums.length)/2)
                return majority_ele;
            if(nums[i]==majority_ele)
                count++;
        }
        return majority_ele;
    }
}