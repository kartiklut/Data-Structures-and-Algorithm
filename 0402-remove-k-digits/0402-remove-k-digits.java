class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Deque<Character> deque=new ArrayDeque<>();
        int maxK=k;
        for(int i=0;i<num.length();i++){
            while(maxK>0 && !deque.isEmpty() && deque.getLast()>num.charAt(i)){
                deque.removeLast();
                maxK--;
            }
            deque.addLast(num.charAt(i));
        }
        while(maxK-->0){
            deque.removeLast();
        }
        StringBuilder sb=new StringBuilder();
        while(!deque.isEmpty()){
            if(sb.length()==0 && deque.getFirst()=='0'){
                deque.removeFirst();
                continue;
            }
            sb.append(deque.getFirst().toString());
            deque.removeFirst();
        }
        return sb.length()==0 ? "0" : sb.toString();
    }
}