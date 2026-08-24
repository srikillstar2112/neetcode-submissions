class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            Comparator.comparingInt(a->a[0])
        );
        pq.offer(new int[]{grid[0][0],0,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int h=curr[0];
            int row=curr[1];
            int col=curr[2];
            if(visited[row][col]){ continue;}
            visited[row][col]=true;
            if(row==n-1 && col==n-1){
                return h;
            }
            for(int[] dir:directions){
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                    int nh=Math.max(h,grid[nr][nc]);
                    pq.offer(new int[]{nh,nr,nc});
                }
            }
        }
        return -1;
    }
}
