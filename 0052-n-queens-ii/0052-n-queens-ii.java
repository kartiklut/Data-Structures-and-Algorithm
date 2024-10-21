class Solution {
    public int totalNQueens(int n) {
        int board[][]=new int[n][n];
        return placeQueens(board,0); //pass board and col and not n cuz at the end we are iterating on row so if all rows are complete then we will have the solution which also means that all queens have been placed.
    }

    public int placeQueens(int board[][],int row){
        if(row>board.length-1){
            return 1;
        }
        int count=0;
        //as we are moving row wise horizontally will be checked automatically cuz we are only place one queen in one row
        for(int col=0;col<board.length;col++){
            if(canIplaceQueens(board,row,col)){ //pass board and places where i want to place my queen
               board[row][col]=1;//do
               count+=placeQueens(board,row+1);//explore
               board[row][col]=0;//undo
            }
        }
        return count;
    }

    public boolean canIplaceQueens(int board[][],int row,int col){
        //check upwards i.e vertically
        for(int r=row;r>=0;r--){
            if(board[r][col]==1){
                return false;
            }
        }

        //check diagonally top left
        //col dec. and row also dec
        for(int r=row,c=col;r>=0 && c>=0 ;r--,c--){
            if(board[r][c]==1){
                return false;
            }
        }

        //check diagonally top right
         for(int r=row,c=col;r>=0 && c<board.length ;r--,c++){
            if(board[r][c]==1){
                return false;
            }
         }

         return true;

    }
}