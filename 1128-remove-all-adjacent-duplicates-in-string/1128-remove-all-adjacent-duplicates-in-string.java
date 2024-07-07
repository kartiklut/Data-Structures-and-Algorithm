class Solution {
    public String removeDuplicates(String s) {
        // abbaca
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty())
                stack.push(s.charAt(i));
            else if(!stack.isEmpty() && stack.peek()!=s.charAt(i))
                stack.push(s.charAt(i));
            else{
                while(!stack.isEmpty() && stack.peek()==s.charAt(i))
                    stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        Iterator value = stack.iterator(); 
        while (value.hasNext()) { 
            sb.append(value.next()); 
        } 
        return sb.toString();
    }
}