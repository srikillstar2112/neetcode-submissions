class Solution {
    int[] dir={0,1,0,-1,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=heights.length;
        int m=heights[0].length;
        boolean[][] pac=new boolean[n][m];
        boolean[][] atl=new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(i,0,pac,heights);
            dfs(i,m-1,atl,heights);
        }
        for(int i=0;i<m;i++){
            dfs(0,i,pac,heights);
            dfs(n-1,i,atl,heights);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pac[i][j] && atl[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    private void dfs(int row,int col, boolean[][] visit,int[][] heights ){
        int n=heights.length;
        int m=heights[0].length;
        if(visit[row][col]) return;
        visit[row][col]=true;
        for(int i=0;i<4;i++){
            int dr=row+dir[i];
            int dc=col+dir[i+1];
            if(dr<0 || dr>=n || dc<0 || dc>=m){
                continue;
            }
            if(heights[dr][dc]<heights[row][col]) continue;
            dfs(dr,dc,visit,heights);
        }
    }
}
