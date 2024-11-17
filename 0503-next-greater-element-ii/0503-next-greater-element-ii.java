class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int res[]=new int[nums.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=2*nums.length-1;i>=0;i--){
            int index=i%nums.length;
            if(stack.isEmpty()){
                stack.push(nums[index]);
                if(i<nums.length){
                    res[index]=-1;
                }
            }else{
                if(nums[index]>=stack.peek()){
                    while(!stack.isEmpty() && nums[index]>=stack.peek()){
                        stack.pop();
                    }
                    if(stack.isEmpty() && i<nums.length){
                        res[index]=-1;
                    }else if(i<nums.length){
                        res[index]=stack.peek();
                    }
                }else if(i<nums.length){
                        res[index]=stack.peek();
                }
                stack.push(nums[index]);
            }
        }
        return res;
    }
}