class Solution {
    public int maxArea(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int max=1;
        while(left<right){
            int b=right-left;
            int h=Integer.min(nums[left],nums[right]);
            int area=b*h;
            if(area>max){
                max=area;
            }
            if(nums[left]<=nums[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
