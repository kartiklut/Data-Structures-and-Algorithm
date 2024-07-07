class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // [[1,4,7,11,15],
        // [2,5,8,12,19],
        // [3,6,9,16,22],   //target =5
        // [10,13,14,17,24],
        // [18,21,23,26,30]
        //We will eleminate the rows and col where our starting pt will be 15 and 18
        //cause either one of them is sorted and decreasing
        //unline other starting pts 1 and 30 where its either inc or dec
        //O(log(n+m))
        int left=0;
        int right=matrix[0].length-1;
        while(right>=0 && left<matrix.length){
            if(matrix[left][right]==target) return true;
            else if(matrix[left][right]>target) right--;
            else left++;
        }
        return false;
    }
}