class Pair{
    int key;
    int value;
    Pair(int key,int value){
        this.key=key;
        this.value=value;
    }

    int getKey(){
        return this.key;
    }

    int getValue(){
        return this.value;
    }
}

class MinStack {

 
    Stack<Pair> stack=new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) { 
       if(stack.isEmpty()){
            Pair pair=new Pair(val,val);
            stack.push(pair);
       }else{
            Pair prevPair=stack.peek(); 
            Pair newPair;
            if(prevPair.getValue()<=val){
                newPair=new Pair(val,prevPair.getValue());
            }else{
                newPair=new Pair(val,val);
            }
            stack.push(newPair);
       }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
         return stack.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */