class Solution {
    public long subArrayRanges(int[] nums) {
        int psee[]=calculatePsee(nums);
        int nse[]=calculateNse(nums);
        int pgee[]=calculatePgee(nums);
        int nge[]=calculateNge(nums);
        long result=0;
        long totalMin=0;
        long totalMax=0;
        for(int i=0;i<nums.length;i++){
            //calculate sum of subarray min
            long pSEE=i-psee[i];
            long nSE=nse[i]-i;
            long pGEE=i-pgee[i];
            long nGE=nge[i]-i;

            long totalSubarraysInMin=(pSEE*nSE);
            long totalCountMin=(totalSubarraysInMin*nums[i]);
            totalMin=totalMin+totalCountMin;

            long totalSubarraysInMax=(pGEE*nGE);
            long totalCountMax=(totalSubarraysInMax*nums[i]);
            totalMax=totalMax+totalCountMax;
            //calculate sum of subarray max
        }
        result=totalMax-totalMin;
        return result;
    }
    int[] calculatePsee(int nums[]){
        Stack<Integer> stack=new Stack<>();
        int psee[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(stack.isEmpty()){
                psee[i]=-1;
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                psee[i]=-1;
            }else{
                psee[i]=stack.peek();
            }
            stack.push(i);
        }
        return psee;
    }

    int[] calculateNse(int nums[]){
        Stack<Integer> stack=new Stack<>();
        int nse[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
                nse[i]=nums.length;
                continue;
            }
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i]=nums.length;
            }else{
                nse[i]=stack.peek();
            }
            stack.push(i);
        }
        return nse;

    }

    int[] calculatePgee(int nums[]){
        Stack<Integer> stack=new Stack<>();
        int pgee[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(stack.isEmpty()){
                pgee[i]=-1;
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pgee[i]=-1;
            }else{
                pgee[i]=stack.peek();
            }
            stack.push(i);
        }
        return pgee;
    }

    int[] calculateNge(int nums[]){
        Stack<Integer> stack=new Stack<>();
        int nge[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            if(stack.isEmpty()){
                nge[i]=nums.length;
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i]=nums.length;
            }else{
                nge[i]=stack.peek();
            }
            stack.push(i);
        }
        return nge;
    }
}