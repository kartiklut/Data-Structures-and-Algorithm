class Solution {
    public int[] findPeakGrid(int[][] mat) {
    //    [41,8,2,48,18],
    //    [16,15,9,7,44],
    //    [48,35,6,38,28],
    //    [3,2,14,15,33],
    //    [39,36,13,46,42]
        int n=mat.length;
        int m=mat[0].length;
        int left=0;
        int right=m-1;
        while(left<=right){
            int mid=left+(right-left)/2; //1
            int indexOfMax=findMaxinCol(mid,mat); //0
            int leftCheck=(mid-1>=0) ? mat[indexOfMax][mid-1] : -1;
            int rightCheck=(mid+1<m) ? mat[indexOfMax][mid+1] : -1;
            if(mat[indexOfMax][mid]>leftCheck && mat[indexOfMax][mid]>rightCheck){
                return new int[]{indexOfMax,mid};
            }else if(mat[indexOfMax][mid]<leftCheck){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    static int findMaxinCol(int col,int mat[][]){
        int max=Integer.MIN_VALUE;
        int indexOfMax=-1;
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]>max){
                max=mat[i][col];
                indexOfMax=i;
            }
        }
        return indexOfMax;
    }
}