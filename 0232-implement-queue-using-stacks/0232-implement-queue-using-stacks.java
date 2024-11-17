class MyQueue {
    Stack<Integer> origStack;
    Stack<Integer> copyStack;

    public MyQueue() {
        origStack=new Stack<>();
        copyStack=new Stack<>();
    }
    
    public void push(int x) {
       origStack.push(x);
    }
    
    public int pop() {
        if(copyStack.isEmpty()){
            while(!origStack.isEmpty()){
                copyStack.push(origStack.pop());
            }
        }
        return copyStack.pop();

    }
    
    public int peek() {
       if(copyStack.isEmpty()){
            while(!origStack.isEmpty()){
                copyStack.push(origStack.pop());
            }
        }
        return copyStack.peek();
    }
    
    public boolean empty() {
        if(origStack.isEmpty() && copyStack.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */