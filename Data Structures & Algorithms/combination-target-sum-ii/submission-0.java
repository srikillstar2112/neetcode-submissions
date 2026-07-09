class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    private void backTrack(int idx,int[] nums,int t,List<List<Integer>> ans,List<Integer> sub){
        
        if(t==0){
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1])continue;
            if(nums[i]>t) break;
            sub.add(nums[i]);
            backTrack(i+1,nums,t-nums[i],ans,sub);
            sub.remove(sub.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}
