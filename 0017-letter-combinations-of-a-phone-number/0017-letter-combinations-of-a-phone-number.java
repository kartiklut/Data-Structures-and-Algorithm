class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> words=new HashMap<>(){{
            put(2,"abc");
            put(3,"def");
            put(4,"ghi");
            put(5,"jkl");
            put(6,"mno");
            put(7,"pqrs");
            put(8,"tuv");
            put(9,"wxyz");
        }};
        if(digits.length()==0) return new ArrayList<>();
        // return letterCombinationsUsingRec(words,digits);
        return letterCombinationsUsingRecSpaceOpt(words,digits,"");
        
    }




    public List<String> letterCombinationsUsingRecSpaceOpt(HashMap<Integer,String> words,String digits,String ans) {
       if(digits.length()==1){
            String lastWord=words.get(digits.charAt(0)-'0');
            List<String> resultString=new ArrayList<>();
            for(int i=0;i<lastWord.length();i++){
                resultString.add(ans+lastWord.charAt(i));
            }
            return resultString;
        }
        char ch=digits.charAt(0);
        String restString=digits.substring(1);
        String initialCharWord=words.get(ch-'0');
        List<String> resultString=new ArrayList<>();
        for(int i=0;i<initialCharWord.length();i++){
            resultString.addAll(letterCombinationsUsingRecSpaceOpt(words,restString,ans+initialCharWord.charAt(i)));
        }
        return resultString;
    }
















    public List<String> letterCombinationsUsingRec(HashMap<Integer,String> words,String digits) {
        if(digits.length()==1){
            String lastWord=words.get(digits.charAt(0)-'0');
            List<String> resultString=new ArrayList<>();
            for(int i=0;i<lastWord.length();i++){
                resultString.add(lastWord.charAt(i)+"");
            }
            return resultString;
        }
        char ch=digits.charAt(0);
        String restString=digits.substring(1);
        List<String> smallerComb=letterCombinationsUsingRec(words,restString);
        String initialCharWord=words.get(ch-'0');
        List<String> resultString=new ArrayList<>();
        for(String small : smallerComb){
            for(int i=0;i<initialCharWord.length();i++){
                resultString.add(initialCharWord.charAt(i)+small);
            }
        }
        return resultString;
    }
    
}