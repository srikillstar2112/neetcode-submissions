class Solution {
    int m,n;
    int[][] dp;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        dp=new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,dfs(matrix,i,j));
            }
        }
        return ans;
    }
    private int dfs(int[][]matrix,int row,int col){
        if(dp[row][col]!=0) return dp[row][col];
        int max=1;
        for(int[] d:dir){
            int nr=row+d[0];
            int nc=col+d[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && matrix[row][col]<matrix[nr][nc]){
                max=Math.max(max,1+dfs(matrix,nr,nc));
            }
        }
        dp[row][col]=max;
        return max;
    }
}
