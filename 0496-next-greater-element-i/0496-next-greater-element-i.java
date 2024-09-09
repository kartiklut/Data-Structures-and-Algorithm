class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[nums1.length];
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(nums2[i]);
                hmap.put(nums2[i],-1);
            }else{
                if(stack.peek()>=nums2[i]){
                    hmap.put(nums2[i],stack.peek());
                    stack.push(nums2[i]);
                }else{
                    while(!stack.isEmpty() && stack.peek()<nums2[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                         hmap.put(nums2[i],-1);
                    }else{
                        hmap.put(nums2[i],stack.peek());
                    }
                    stack.push(nums2[i]);
                }
            }
        }
        for(int i=0;i<nums1.length;i++){
            res[i]=hmap.get(nums1[i]);
        }
        return res;
    }
}