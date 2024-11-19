class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque=new ArrayDeque<>();
        for(int i=0;i<num.length();i++){
            if(deque.isEmpty()){
                deque.addLast(num.charAt(i));
            }else{
                while(!deque.isEmpty() && deque.getLast()>num.charAt(i) && k>0){
                    k--;
                    deque.removeLast();
                }
                deque.addLast(num.charAt(i));
            }
        }
        while(k>0 && !deque.isEmpty()){
            k--;
            deque.removeLast();
        }

        while(!deque.isEmpty() && deque.getFirst()=='0'){
            deque.removeFirst();
        }

        if(deque.isEmpty()){
            return "0";
        }

        StringBuilder sb=new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}