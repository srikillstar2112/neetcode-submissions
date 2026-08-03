class Solution {
    public boolean canPartition(int[] nums) {
        int totsum=0;
        int n=nums.length;
        for(int i:nums){
            totsum+=i;
        }
        if(totsum%2!=0) return false;
        int sum=totsum/2;
        boolean[] prev=new boolean[sum+1];
        prev[0]=true;
        if(nums[0]<=sum){
            prev[nums[0]]=true;
        }
        for(int i=1;i<n;i++){
            boolean[] curr=new boolean[sum+1];
            curr[0]=true;
            for(int j=1;j<=sum;j++){
                boolean nottake=prev[j];
                boolean take=false;
                if(nums[i]<=j){
                    take=prev[j-nums[i]];
                }
                curr[j]=take || nottake;
            }
            prev=curr;
        }
        return prev[sum];
    }
}
