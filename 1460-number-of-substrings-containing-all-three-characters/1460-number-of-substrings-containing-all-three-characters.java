class Solution {
    public int numberOfSubstrings(String s) {
        //abcabc
        //count=5
        HashMap<Character,Integer> hmap=new HashMap<>();
        int left=0;
        int right=0;
        int count=0;
        while(right<s.length()){
            hmap.put(s.charAt(right),hmap.getOrDefault(s.charAt(right),0)+1);
            while(hmap.size()==3 && (hmap.get('a')>=1 && hmap.get('b')>=1 && hmap.get('c')>=1)){
                count+=s.length()-right;
                hmap.put(s.charAt(left),hmap.get(s.charAt(left))-1);
                left++;
            }
            right++;
        }
        return count;
    }
}