class Solution {
    public boolean canJump(int[] nums) {
       if(nums.length==1) return true;
       int n=nums.length-1;
        int curr=0;
        while(curr<=n && nums[curr]!=0){
            curr+=nums[curr];
            if (curr>=n) return true;
        }
        return false;
    }
}
