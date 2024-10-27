class Solution {

    class Pair implements Comparable<Pair>{
        int ele;
        int freq;

        Pair(int ele,int freq){
            this.ele=ele;
            this.freq=freq;
        }

        public int compareTo(Pair obj){
            return obj.freq-this.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int ele : nums){
            freqMap.put(ele,freqMap.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>();

        for(Map.Entry<Integer,Integer> map : freqMap.entrySet()){
            Pair p=new Pair(map.getKey(),map.getValue());
            maxHeap.add(p);
        }

        int resArr[]=new int[k];
        int index=0;
        while(k-->0){
            resArr[index]=maxHeap.poll().ele;
            index++;
        }
        return resArr;
    }
}