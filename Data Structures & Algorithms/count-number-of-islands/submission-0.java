
class Solution {

    private void bfs(int row,int col,char[][] grid){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{row,col});
        grid[row][col]='0';
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int[] d:dir){
                int dr=r+d[0];
                int dc=c+d[1];
                if(dr>=0 && dr<grid.length && dc>=0 && dc<grid[0].length && grid[dr][dc]=='1'){
                    q.offer(new int[]{dr,dc});
                    grid[dr][dc]='0';
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int c=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]=='1'){
                    c++;
                    bfs(row,col,grid);
                }
            }
        }
        return c;
    }
}
