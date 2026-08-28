class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int tot=0;
        for(int n:nums){
            tot+=n;
        }
        if (Math.abs(target) > tot) {
            return 0;
        }
        int off=tot;
        int[][] dp=new int[nums.length+1][2*tot+1];
        dp[0][off]=1;
        for(int i=0;i<nums.length;i++){
            for(int sum=-tot;sum<=tot;sum++){
                int idx=sum+off;
                if(dp[i][idx]==0){
                    continue;
                }
                dp[i+1][sum+nums[i]+off]+=dp[i][idx];
                dp[i+1][sum-nums[i]+off]+=dp[i][idx];
            }
        }
        return dp[nums.length][target+off];
    }
}
