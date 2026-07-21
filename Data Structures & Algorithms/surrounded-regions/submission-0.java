class Solution {
    int[] dir={0,-1,0,1,0};
    private void dfs(char[][] board,int row,int col){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length){
            return;
        }
        if(board[row][col]!='O'){
            return;
        }
        board[row][col]='T';
        for(int i=0;i<4;i++){
            dfs(board,row+dir[i],col+dir[i+1]);
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            dfs(board,i,0);
            dfs(board,i,m-1);
        }
        for(int i=0;i<m;i++){
            dfs(board,0,i);
            dfs(board,n-1,i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
}
