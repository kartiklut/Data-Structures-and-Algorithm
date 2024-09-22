class Solution {
    public int calculate(String s) {
    //"2-4-(8+2-6+(8+4-(1)+8-10))"

       int result=0;
       int number=0;
       int sign=1;
       Stack<Integer> stack =new Stack<>();
       for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
                continue;
            if(s.charAt(i)=='-' || s.charAt(i)=='+'){
                result=result+(sign*number);
                number=0;
                sign=s.charAt(i)=='-' ? -1 : 1;
            }else if(s.charAt(i)=='('){
                //start story again
                stack.push(result);
                stack.push(sign);
                result=0;
                number=0;
                sign=1;
            }else if(s.charAt(i)==')'){
                result=result+(sign*number);
                number=0;
                sign=stack.pop();
                result*=sign;
                result+=stack.pop();
            }else{
                number=(number*10)+s.charAt(i)-'0';
            }
       }
       result=result+(sign*number);
       return result;
    }
}