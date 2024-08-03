class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> hmap=new HashMap<>();
        int mostFreqCount=0;
        int maxLen=0;
        int left=0;
        int right=0;
        while(right<s.length()){
            hmap.put(s.charAt(right),hmap.getOrDefault(s.charAt(right),0)+1);
            for(Integer value:hmap.values()){
                mostFreqCount=Math.max(mostFreqCount,value);
            }
            int replaceCharCount=right-left+1-mostFreqCount;
            while(replaceCharCount>k && left<right){
                hmap.put(s.charAt(left),hmap.get(s.charAt(left))-1);
                if(hmap.get(s.charAt(left))==0){
                    hmap.remove(s.charAt(left));
                }
                for(Integer value:hmap.values()){
                    mostFreqCount=Math.max(mostFreqCount,value);
                }
                left++;
                replaceCharCount=right-left+1-mostFreqCount;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}