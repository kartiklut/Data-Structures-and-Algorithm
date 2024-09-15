class Pair{
    int stock;
    int span;

    Pair(int stock,int span){
        this.stock=stock;
        this.span=span;
    }

    int getStock(){
        return stock;
    }

    int getSpan(){
        return span;
    }
}
class StockSpanner {
    Stack<Pair> stack =new Stack<>();


    public StockSpanner() {
        
    }
    
    public int next(int price) {
        if(stack.isEmpty()){
            stack.push(new Pair(price,1));
            return 1;
        }
        int count=1;
        while(!stack.isEmpty() && stack.peek().getStock()<=price){
            count+=stack.peek().getSpan();
            stack.pop();
        }
        stack.push(new Pair(price,count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */