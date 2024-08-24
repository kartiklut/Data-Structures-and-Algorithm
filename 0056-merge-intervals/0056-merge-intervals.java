class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> resAl=new ArrayList<>();
        int right=intervals[0][1];
        int left=intervals[0][0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=right && intervals[i][1]>=right){
                right=intervals[i][1];
                continue;
            }else if(intervals[i][1]>right){
                ArrayList<Integer> al=new ArrayList<>(Arrays.asList(left,right));
                resAl.add(al);
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        ArrayList<Integer> all=new ArrayList<>(Arrays.asList(left,right));
        resAl.add(all);
        int resArr[][]=new int[resAl.size()][2];
        int index=0;
        for(List<Integer> al : resAl){
            resArr[index][0]=al.get(0);
            resArr[index][1]=al.get(1);
            index++;
        }
        return resArr;
    }
}