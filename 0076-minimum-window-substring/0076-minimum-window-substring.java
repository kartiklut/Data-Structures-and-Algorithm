class Solution {
    public String minWindow(String s, String t) {
        //s = "cabwefgewcwaefgcf", t = "cae"
        HashMap<Character,Integer> origFreqMap=new HashMap<>();
        for(int i=0;i<t.length();i++){
            origFreqMap.put(t.charAt(i),origFreqMap.getOrDefault(t.charAt(i),0)+1);
        }
        int left=0;
        int right=0;
        int minLen=Integer.MAX_VALUE;
        int startIndex=-1;
        int tReceived=0;
        while(right<s.length()){
            if(origFreqMap.containsKey(s.charAt(right))){
                if(origFreqMap.get(s.charAt(right))>0){
                    tReceived++;
                }
                origFreqMap.put(s.charAt(right),origFreqMap.get(s.charAt(right))-1);
            }else{
                origFreqMap.put(s.charAt(right),-1);
            }
            while(tReceived==t.length() && left<=right){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    startIndex=left;
                }
                origFreqMap.put(s.charAt(left),origFreqMap.get(s.charAt(left))+1);
                if(origFreqMap.get(s.charAt(left))>0){
                    tReceived--;
                }
                left++;
            }
            right++;
        }
        if(startIndex<0) return "";
        return s.substring(startIndex,startIndex+minLen);
    }
}