class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        for(int i=queue.size()-2;i>=0;i--){
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        if(queue.size()==0) return true;
        else return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */