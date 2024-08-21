class Solution {
    public void setZeroes(int[][] matrix) {
        //Optimal Solution -In Place

        int n=matrix.length;
        int m=matrix[0].length;
        int colK=matrix[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0){
                        matrix[0][j]=0;
                    }
                    else{
                        colK=0;
                    }
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int i=0;i<m;i++){
                matrix[0][i]=0;
            }
        }
        if(colK==0){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }





















        //Better Solution Space O(n+m) Time=O(nXm)
        // int n=matrix.length;
        // int m=matrix[0].length;
        // int colArr[]=new int[m];
        // int rowArr[]=new int[n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(matrix[i][j]==0){
        //             colArr[j]=-1;
        //             rowArr[i]=-1;
        //         }
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(colArr[j]==-1) matrix[i][j]=0;
        //         if(rowArr[i]==-1) matrix[i][j]=0;
        //     }
        // }
    }
}