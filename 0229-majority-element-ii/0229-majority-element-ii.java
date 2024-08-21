class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //[3,2,3,2,2,3]
       if(nums.length==1) return Arrays.asList(nums[0]);
       int index=0;
       int majCandidate1=Integer.MIN_VALUE;
       int majCount1=0;
       int majCandidate2=Integer.MIN_VALUE;
       int majCount2=0;
       while(index<nums.length){
            if(majCount1 ==0 && nums[index]!=majCandidate2){
                majCount1++;
                majCandidate1=nums[index];
            }else if(majCount2==0 && nums[index]!=majCandidate1){
                majCount2++;
                majCandidate2=nums[index];
            }else if(nums[index]==majCandidate1){
                majCount1++;
            }else if(nums[index]==majCandidate2){
                majCount2++;
            }else{
                majCount1--;
                majCount2--;
            }
            index++;
       }
       index=0;
       majCount1=0;
       majCount2=0;
       while(index<nums.length){
            if(nums[index]==majCandidate1){
                majCount1++;
            }
            if(nums[index]==majCandidate2){
                majCount2++;
            }
            index++;
       }
       List<Integer> resAl=new ArrayList<>();
       if(majCount1>nums.length/3){
            resAl.add(majCandidate1);
       }
       if(majCount2>nums.length/3 && !resAl.contains(majCandidate2)){
            resAl.add(majCandidate2);
       }
       Collections.sort(resAl);
       return resAl;
    }
}