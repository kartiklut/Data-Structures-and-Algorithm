class Solution {
    public List<List<String>> partition(String s) {
        return part(s,new ArrayList<>(),new ArrayList<>());
    }

    public List<List<String>> part(String s,List<String> validPartSoFar,List<List<String>> result){
        if(s.length()==0){
            result.add(new ArrayList<>(validPartSoFar));
            return result;
        }

        for(int i=0;i<s.length();i++){
            String prefix=s.substring(0,i+1);
            if(isPalindrome(prefix)){
                validPartSoFar.add(prefix);
                part(s.substring(i+1),validPartSoFar,result);
                validPartSoFar.remove(validPartSoFar.size()-1);
            }
        }
        return result;
    }

    public boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}