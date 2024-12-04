class Pair{
    char ele;
    int freq;

    Pair(char ele,int freq){
        this.ele=ele;
        this.freq=freq;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(new Pair(s.charAt(i),1));
            }else{
                if(stack.peek().ele==s.charAt(i) && stack.peek().freq==k-1){
                    stack.pop();
                }else if(stack.peek().ele==s.charAt(i)){
                    Pair top=stack.pop();
                    top.freq+=1;
                    stack.push(top);
                }else{
                    stack.push(new Pair(s.charAt(i),1));
                }
            }
        }

        StringBuffer sb=new StringBuffer();
        while(!stack.isEmpty()){
            Pair top=stack.pop();
            for(int i=0;i<top.freq;i++){
                sb.append(top.ele);
            }
        }
        sb.reverse();
        return sb.toString();
    }
}