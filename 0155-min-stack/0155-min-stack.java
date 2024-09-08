class MinStack {

    Stack<Integer> stack=new Stack<>();
    int min=Integer.MAX_VALUE;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(val<=min) min=val;
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
        min=Integer.MAX_VALUE;
        for(int i=0;i<stack.size();i++){
            min=Math.min(min,stack.get(i));
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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