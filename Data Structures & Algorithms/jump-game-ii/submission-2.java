class Solution {
    public int jump(int[] nums) {
        int curr=0;
        int farthest=0;
        int n=nums.length;
        int c=0;
        for(int i=0;i<n-1;i++){
            farthest=Math.max(farthest,i+nums[i]);
            if(i==curr){
                c++;
                curr=farthest;
            }        
        }
        return c;
    }
}
