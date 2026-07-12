class Solution {
    private void backtrack(int[] nums,List<Integer> sub,List<List<Integer>> ans,boolean[] freq){
        if(sub.size()==nums.length){
            ans.add(new ArrayList<>(sub));
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                sub.add(nums[i]);
                backtrack(nums,sub,ans,freq);
                sub.remove(sub.size()-1);
                freq[i]=false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] freq=new boolean[nums.length];
        backtrack(nums,new ArrayList<>(),ans,freq);
        return ans;
    }
}
