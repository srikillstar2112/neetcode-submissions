class Solution {
    private int rob(int[] nums,int start,int end){
        int i2=0;
        int i1=0;
        for(int i=start;i<=end;i++){
            int curr=Math.max(i1,i2+nums[i]);
            i2=i1;
            i1=curr;
        }
        return i1;
    }
    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }
}
