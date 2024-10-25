class Solution {
    public boolean exist(char[][] board, String word) {
        int visited[][]=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean check=checkWord(board,word,visited,i,j);
                    if(check) return check;
                }
            }
        }
        return false;
    }

    public boolean checkWord(char board[][],String word,int visited[][],int currRow,int currCol){
        if(word.length()==0){
            return true;
        }
        if(currRow<0 || currRow>board.length-1 || currCol<0 || currCol>board[0].length-1 || visited[currRow][currCol]==-1
                        || (word.length()>0 && board[currRow][currCol]!=word.charAt(0))){
            return false;
        }


        visited[currRow][currCol]=-1;
        boolean right=checkWord(board,word.substring(1),visited,currRow,currCol+1);
        boolean left=checkWord(board,word.substring(1),visited,currRow,currCol-1);
        boolean down=checkWord(board,word.substring(1),visited,currRow+1,currCol);
        boolean up=checkWord(board,word.substring(1),visited,currRow-1,currCol);
        visited[currRow][currCol]=0;

        return right || left || down || up;
    }
}