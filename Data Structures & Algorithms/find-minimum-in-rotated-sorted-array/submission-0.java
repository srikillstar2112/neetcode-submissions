class Solution {
    public int findMin(int[] nums) {
        int left=nums[0];
      for(int i=0;i<nums.length;i++){
        left=Math.min(left,nums[i]);
      }  
      return left;
    }
}
