class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int nge[]=new int[nums.length];
        for(int i=2*nums.length-1;i>=0;i--){
            if(i>=nums.length){
                if(stack.isEmpty()){
                    stack.push(nums[i%nums.length]);
                }else{
                    while(!stack.isEmpty() && stack.peek()<=nums[i%nums.length]){
                        stack.pop();
                    }
                    stack.push(nums[i%nums.length]);
                }
            }else{
                if(stack.isEmpty()){
                    nge[i]=-1;
                    stack.push(nums[i]);
                }else{
                    while(!stack.isEmpty() && stack.peek()<=nums[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        nge[i]=-1;
                    }else{
                        nge[i]=stack.peek();
                    }
                    stack.push(nums[i]);
                }
            }
        }
        return nge;
    }
}