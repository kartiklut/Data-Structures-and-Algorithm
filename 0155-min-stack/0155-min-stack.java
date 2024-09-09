class MinStack {
    Stack<Long> stack=new Stack<>();
    Long min=0L;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(Long.valueOf(val));
            min=Long.valueOf(val);
        }else{
            if(val<=min.intValue()){
                //Store the encrypted value
                Long newValue=2*Long.valueOf(val)-min;
                stack.push(newValue);
                min=Long.valueOf(val);
            }else{
                stack.push(Long.valueOf(val));
            }
        }
    }
    
    public void pop() {
        //check if encrypted value is stored
        if(stack.peek()<=min){
            //if encrypted is stored then decrypt it and update min
            Long currEncryptedValue=stack.peek();
            min=2*min-currEncryptedValue;
        }
        stack.pop();
    }
    
    public int top() {
        //check if stack's top is encrypted
        if(stack.peek()<=min){
            return min.intValue();
        }
        return stack.peek().intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}


//Approach 1
// class Pair{
//     int key;
//     int value;
//     Pair(int key,int value){
//         this.key=key;
//         this.value=value;
//     }

//     int getKey(){
//         return this.key;
//     }

//     int getValue(){
//         return this.value;
//     }
// }

// class MinStack {

 
//     Stack<Pair> stack=new Stack<>();

//     public MinStack() {
        
//     }
    
//     public void push(int val) { 
//        if(stack.isEmpty()){
//             Pair pair=new Pair(val,val);
//             stack.push(pair);
//        }else{
//             Pair prevPair=stack.peek(); 
//             Pair newPair;
//             if(prevPair.getValue()<=val){
//                 newPair=new Pair(val,prevPair.getValue());
//             }else{
//                 newPair=new Pair(val,val);
//             }
//             stack.push(newPair);
//        }
//     }
    
//     public void pop() {
//         stack.pop();
//     }
    
//     public int top() {
//         return stack.peek().getKey();
//     }
    
//     public int getMin() {
//          return stack.peek().getValue();
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */