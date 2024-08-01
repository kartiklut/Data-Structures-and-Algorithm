class Solution {
    //abcabcbb
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hmap=new HashMap<>();
        int left=0;
        int right=0;
        int max_len=0;
        while(right<s.length()){
            char ch=s.charAt(right);
            while(left<=right && hmap.containsKey(ch)){
                hmap.remove(s.charAt(left));
                left++;
            }
            hmap.put(ch,right);
            max_len=Math.max(max_len,right-left+1);
            right++;
        }
        return max_len;
    }
}