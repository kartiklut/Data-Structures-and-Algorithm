class Solution {
                    //check for queens 2 first
    public List<List<String>> solveNQueens(int n) {
        if(n==1){
            List<String> resultAl=new ArrayList<>(Arrays.asList("Q"));
            return new ArrayList<>(Arrays.asList(resultAl));
        }
        char board[][]=new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> resultAl=new ArrayList<>();
        return queens(board,0,resultAl);
    }

    public List<List<String>> queens(char board[][],int row,List<List<String>> resultAl){
        if(row==board.length){
            List<String> possibleAnsList=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                String str="";
                for(int j=0;j<board[0].length;j++){
                    str+=board[i][j];
                }
                possibleAnsList.add(str);
            }
            resultAl.add(possibleAnsList);
            return resultAl;
        }

        
        for(int col=0;col<board[0].length;col++){
            if(canIPlaceQueens(board,row,col)){
                board[row][col]='Q';
                queens(board,row+1,resultAl);
                board[row][col]='.';
            }
        }
        return resultAl;
    }

    public boolean canIPlaceQueens(char board[][],int row,int col){
        //check horizontally if i can place
        for(int r=row;r>=0;r--){
            if(board[r][col]=='Q'){
                return false;
            }
        }

        //check diagonally top left
        for(int r=row,c=col;r>=0 && c>=0;r--,c--){
            if(board[r][c]=='Q'){
                return false;
            }
        }

        //check diagonally top right
        for(int r=row,c=col;r>=0 && c<board[0].length;r--,c++){
             if(board[r][c]=='Q'){
                return false;
            }
        }

        return true;
    }
}