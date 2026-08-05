class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int curr=0;
        for(int i=0;i<n;i++){
            if(i>curr) return false;
            curr=Math.max(curr,i+nums[i]);
            if(curr>=n-1){
                return true;
            }
        }
        return true;
    }
}
