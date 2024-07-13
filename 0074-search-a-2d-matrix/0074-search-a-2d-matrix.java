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
         // [1, 3, 5, 7],    target=13
         // [10,11,16,20],
         // [23,30,34,60]
         //Make this hypothetically 1-d sorted array then apply BS
         int n=matrix.length;
         int m=matrix[0].length;
         int left=0;
         int right=n*m-1;
         while(left<=right){
            int mid=left+(right-left)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]>target) right=mid-1;
            else left=mid+1;
         }
         return false;
     }
}