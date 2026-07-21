class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]==2){
                    q.offer(new int[]{row,col});
                }else if(grid[row][col]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int[] dir={0,1,0,-1,0};
        int min=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] curr=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int i=0;i<4;i++){
                    int dr=r+dir[i];
                    int dc=c+dir[i+1];
                    if(dr<0 || dr>=n || dc<0 || dc>=m)continue;
                    if(grid[dr][dc]==1){
                        grid[dr][dc]=2;fresh--;
                        q.offer(new int[]{dr,dc});
                    }
                }
            }
            min++;
        }
        return fresh==0? min-1: -1;
    }
}
