class Solution {

    class Pair implements Comparable<Pair>{
        int ele;
        int freq;

        Pair(int ele,int freq){
            this.ele=ele;
            this.freq=freq;
        }

        public int compareTo(Pair obj){
            return this.freq-obj.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int ele : nums){
            freqMap.put(ele,freqMap.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Pair> minHeap=new PriorityQueue<>();

        for(Map.Entry<Integer,Integer> map : freqMap.entrySet()){
            Pair p=new Pair(map.getKey(),map.getValue());
            minHeap.add(p);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int resArr[]=new int[k];
        int index=0;
        while(k-->0){
            resArr[index]=minHeap.poll().ele;
            index++;
        }
        return resArr;



        
    }
}