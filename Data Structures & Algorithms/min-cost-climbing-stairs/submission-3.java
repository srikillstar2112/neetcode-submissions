class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(solve(cost, n - 1),
                        solve(cost, n - 2));
    }
    private int solve(int[] cost, int i) {
        if (i == 0)
            return cost[0];
        if (i == 1)
            return cost[1];
        if (dp[i] != -1)
            return dp[i];
        dp[i] = cost[i] +
                Math.min(solve(cost, i - 1),
                         solve(cost, i - 2));
        return dp[i];
    }
}