class Solution {

    //                  Better - O(n*log(m))
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     // [[1, 3, 5, 7],    target=13
    //     // [10,11,16,20],
    //     // [23,30,34,60]]
    //     int n=matrix.length;
    //     int m=matrix[0].length;
    //     for(int i=0;i<n;i++){
    //         //check if my ans lies in b/w this range //if yes then apply BS on that row
    //         if(matrix[i][0]<=target && matrix[i][m-1]>=target){
    //             return applyBinarySearchonRow(matrix[i],target);
    //         }
    //     }
    //     return false;
    // }

    // static boolean applyBinarySearchonRow(int row[],int target){
    //     int left=0;
    //     int right=row.length-1;
    //     while(left<=right){
    //         int mid=left+(right-left)/2;
    //         if(row[mid]==target) return true;
    //         else if(row[mid]>target) right=mid-1;
    //         else left=mid+1;
    //     }
    //     return false;
    // }




























     public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            int left=0;
            int right=m-1;
            if(matrix[i][left]<=target && matrix[i][right]>=target){
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(matrix[i][mid]==target)
                        return true;
                    else if(matrix[i][mid]<target){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
            }
        }
        return false;

     }
}