class Solution {

    class Distance implements Comparable<Distance>{
        int distance;
        int x;
        int y;

        Distance(int distance,int x,int y){
            this.distance=distance;
            this.x=x;
            this.y=y;
        }

        public int compareTo(Distance d){
            return d.distance-this.distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Distance> maxHeap=new PriorityQueue<Distance>();
        for(int x=0;x<points.length;x++){
            int disX=points[x][0];
            int disY=points[x][1];
            int eucDistance=(int)Math.pow(disX,2)+(int)Math.pow(disY,2);
            Distance currD=new Distance(eucDistance,disX,disY);
            maxHeap.add(currD);
            if(maxHeap.size()>k){
                maxHeap.poll();
            } 
        }
    
        int resArr[][]=new int[k][2];
        for(int x=0;x<k;x++){
            Distance d=maxHeap.poll();
            resArr[x][0]=d.x;
            resArr[x][1]=d.y;
        }

        return resArr;

    }
}