class Solution {
    public boolean isValid(String s) {
        //whichever is opened recently should be closed first that's it
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else if(stack.isEmpty() && (s.charAt(i)==')' || s.charAt(i)=='}' || s.charAt(i)==']')){
                return false;
            }else{
                if(s.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else if(s.charAt(i)==']' && !stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                }else if(s.charAt(i)=='}' && !stack.isEmpty() && stack.peek()=='{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}