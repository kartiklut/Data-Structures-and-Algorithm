class Temperature{
    int index;
    int temp;

    Temperature(int index,int temp){
        this.index=index;
        this.temp=temp;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Temperature> stack=new Stack<>();
        int resArr[]=new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            if(stack.isEmpty()){
                resArr[i]=0;
                stack.push(new Temperature(i,temperatures[i]));
            }else{
                while(!stack.isEmpty() && stack.peek().temp<=temperatures[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    resArr[i]=0;
                }else{
                    resArr[i]=stack.peek().index-i;
                }
                stack.push(new Temperature(i,temperatures[i]));
            }
        }
        return resArr;
    }
}