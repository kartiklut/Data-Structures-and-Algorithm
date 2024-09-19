class Solution {
    public int sumSubarrayMins(int[] arr) {
        int pse[]=calculatePse(arr);
        int nsee[]=calculateNsee(arr);
        long count=0;
        long mod=(int)1e9+7;
        for(int i=0;i<arr.length;i++){
            long pSE=i-pse[i];
            long nSEE=nsee[i]-i;
            long noOfPossibleSubarrayIncMe=(pSE*nSEE)%mod;
            long total=(arr[i]*noOfPossibleSubarrayIncMe)%mod;
            count = (count + total) % mod;
        }
        return (int)count;
    }

    int[] calculateNsee(int arr[]){
        Stack<Integer> stack=new Stack<>();
        int resArr[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
                resArr[i]=arr.length;
                continue;
            }
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                resArr[i]=arr.length;
                stack.push(i);
            }else{
                resArr[i]=stack.peek();
                stack.push(i);
            }
        }
        return resArr;
    }

    int[] calculatePse(int arr[]){
        Stack<Integer> stack=new Stack<>();
        int resArr[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
                resArr[i]=-1;
                continue;
            }
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                resArr[i]=-1;
                stack.push(i);
            }else{
                resArr[i]=stack.peek();
                stack.push(i);
            }
        }
        return resArr;
    }


}