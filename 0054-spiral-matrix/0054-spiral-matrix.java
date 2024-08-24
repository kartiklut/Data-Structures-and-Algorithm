class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> resAl=new ArrayList<>();
        int left=0;
        int top=0;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                resAl.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                resAl.add(matrix[i][right]);
            }
             right--;
            if(top<=bottom && left<=right){
                for(int i=right;i>=left;i--){
                    resAl.add(matrix[bottom][i]);
                }
                bottom--;
                for(int i=bottom;i>=top;i--){
                    resAl.add(matrix[i][left]);
                }
                left++;
            }
        }
        return resAl;
    }
}