class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length();
        int n=s2.length();
        int l=s3.length();
        if(m+n!=l) return false;
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=m;i++){
            dp[0][i]=dp[0][i-1] && s1.charAt(i-1)==s3.charAt(i-1);
        }
        for(int j=1;j<=n;j++){
            dp[j][0]=dp[j-1][0] && s2.charAt(j-1)==s3.charAt(j-1);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=(dp[i-1][j] && s2.charAt(i-1)==s3.charAt(i+j-1))||
                         (dp[i][j-1] && s1.charAt(i-1)==s3.charAt(i+j-1));
            }
        }
        return dp[n][m];
    }
}
