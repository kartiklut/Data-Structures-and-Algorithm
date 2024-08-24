class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            reverseRows(matrix,i,m-1);
        }
    }
    private void reverseRows(int matrix[][],int row,int end){
      int iterator=0;
      int start=0;
      while(start<=end){
        int temp=matrix[row][end];
        matrix[row][end]=matrix[row][iterator];
        matrix[row][iterator]=temp;
        iterator++;
        start++;
        end--;
      }
    }
}