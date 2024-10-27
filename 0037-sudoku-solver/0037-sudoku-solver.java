class Solution {
    public void solveSudoku(char[][] board) {
        
        sudoko(board,0,0);
    }

    public boolean sudoko(char board[][],int sourceRow,int sourceCol){

        if(sourceRow==board.length){
            return true;
        }

        if (sourceCol == board[0].length) {
            return sudoko(board, sourceRow + 1, 0);
        }

        if(board[sourceRow][sourceCol]!='.'){
             return sudoko(board,sourceRow,sourceCol+1);
        }else{
            for (char options = '1'; options <= '9'; options++) {
                if(canIplaceThisOption(board,sourceRow,sourceCol,options)){
                    board[sourceRow][sourceCol]=options;
                    if(sudoko(board,sourceRow,sourceCol+1)){
                        return true;
                    }
                    board[sourceRow][sourceCol]='.';
                }
            }
        }
        return false;
    }

    public boolean canIplaceThisOption(char board[][],int sourceRow,int sourceCol,char possibleOption){
        //check horizontally
        for(int i=0;i<board[0].length;i++){
            if(board[sourceRow][i]==possibleOption){
                return false;
            }
        }

        //check vertically
        for(int i=0;i<board.length;i++){
            if(board[i][sourceCol]==possibleOption){
                return false;
            }
        }

        //check in current 3x3 matrix
        //Trick =Find the starting point then start iterating
        //row/3*3 col/3*3
        int startRow=(sourceRow/3)*3;
        int startCol=(sourceCol/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[startRow+i][startCol+j]==possibleOption){
                    return false;
                }
            }
        }
        return true;
    }
}