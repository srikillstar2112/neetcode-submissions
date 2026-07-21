class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[] dir={0,1,0,-1,0};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int i=0;i<4;i++){
                int dr=r+dir[i];
                int dc=c+dir[i+1];
                if(dr<0 || dr>=m || dc<0 || dc>=n) continue;
                if(grid[dr][dc]!=Integer.MAX_VALUE) continue;
                grid[dr][dc]=grid[r][c]+1;
                q.offer(new int[]{dr,dc});
            }
        }
    }
}
