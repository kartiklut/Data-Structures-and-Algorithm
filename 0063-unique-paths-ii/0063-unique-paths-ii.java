class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int cache[][]=new int[grid.length+1][grid[0].length+1];
        for(int[] arr : cache){
            Arrays.fill(arr,-1);
        }
        return uniquePaths(grid,0,0,cache);
    }

    public int uniquePaths(int grid[][],int row,int col,int cache[][]){
        if(row>grid.length-1 || col>grid[0].length-1 || grid[row][col]==1) return 0;
        if(row==grid.length-1 && col==grid[0].length-1) return 1;

        if(cache[row][col]!=-1) return cache[row][col];

        int right=uniquePaths(grid,row+1,col,cache);
        int down=uniquePaths(grid,row,col+1,cache);
        
        return cache[row][col]=right+down;
    }
}