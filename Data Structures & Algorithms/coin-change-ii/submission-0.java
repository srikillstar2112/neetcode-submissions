class Solution {
    private int solve(int idx,int t,int[] coins, int n){
        if(idx==0){
            return t%coins[0]==0? 1:0;
        }
        int ntake=solve(idx-1,t,coins,n);
        int take=0;
        if(coins[idx]<=t){
            take=solve(idx,t-coins[idx],coins,n);
        }
        return take+ntake;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        return solve(n-1,amount,coins,n);
    }
}
