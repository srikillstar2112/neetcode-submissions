class Solution {
    private int bfs(int row,int col, int[][] grid,int max){
        Queue<int[]> q=new LinkedList<>();
        int temp=1;
        q.offer(new int[]{row,col});
        grid[row][col]=0;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int[] d:dir){
                int dr=r+d[0];
                int dc=c+d[1];
                if(dr>=0 && dr<grid.length && dc>=0 && dc<grid[0].length && grid[dr][dc]==1){
                    temp+=1;
                    q.offer(new int[]{dr,dc});
                    grid[dr][dc]=0;
                }
            }
        }
        return temp;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int max=0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]==1){
                    int area=bfs(row,col,grid,max);
                    max=Math.max(area,max);
                }
            }
        }
        return max;
    }
}
