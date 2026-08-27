class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        int[] curr=new int[amount+1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0){
                prev[t]=1;
            }
        }
        for(int idx=1;idx<n;idx++){
            for(int t=0;t<=amount;t++){
                int ntake=prev[t];
                int take=0;
                if(coins[idx]<=t){
                    take=curr[t-coins[idx]];
                }
                curr[t]=take+ntake;
            }
            prev=curr;
            curr=new int[amount+1];
        }
        return prev[amount];
    }
}
