class Pair{
    int temp;
    int warmCount;

    Pair(int temp,int warmCount){
        this.temp=temp;
        this.warmCount=warmCount;
    }

    int getTemp(){
        return temp;
    }

    int getWarmCount(){
        return warmCount;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack=new Stack<>();
        int arr[]=new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            if(stack.isEmpty()){
                arr[i]=0;
                stack.push(new Pair(temperatures[i],0));
                continue;
            }
            int count=1;
            while(!stack.isEmpty() && stack.peek().getTemp()<=temperatures[i]){
                count+=stack.peek().getWarmCount();
                stack.pop();
            }
            if(stack.isEmpty()){
                count=0;
            }
            stack.push(new Pair(temperatures[i],count));
            arr[i]=count;
        }
        return arr;
    }
}