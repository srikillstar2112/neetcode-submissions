class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    private void backTrack(int idx,int[] nums,int t, List<List<Integer>> ans,List<Integer> sub){
        if(idx==nums.length){
            if(t==0){
                ans.add(new ArrayList<>(sub));
            }
            return;
        }
        if(t==0 && idx<nums.length){
            ans.add(new ArrayList<>(sub));
            return;
        }
        if(nums[idx]<=t){
            sub.add(nums[idx]);
            backTrack(idx,nums,t-nums[idx],ans,sub);
            sub.remove(sub.size()-1);
        }
        backTrack(idx+1,nums,t,ans,sub);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backTrack(0,nums,target,ans,new ArrayList<>());
        return ans;
    }
}
