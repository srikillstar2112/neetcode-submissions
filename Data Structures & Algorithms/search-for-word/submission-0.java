class Solution {
    private boolean checker(int idx,String word,char[][] board,int i,int j){
        //Out of bounds
        if(i<0 || j<0 || i==board.length || j==board[0].length){
            return false;
        }
        if(idx==word.length()){
            return true;
        }
        if(board[i][j]!=word.charAt(idx)){
            return false;
        }
        char t=board[i][j];
        board[i][j]='#';
        boolean found=checker(idx+1,word,board,i+1,j) || 
                       checker(idx+1,word,board,i-1,j) ||
                       checker(idx+1,word,board,i,j+1) ||
                       checker(idx+1,word,board,i,j-1);
        board[i][j]=t;
        return found;
        
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(checker(0,word,board,i,j)) return true;
            }
        }
        return false;
    }
}
