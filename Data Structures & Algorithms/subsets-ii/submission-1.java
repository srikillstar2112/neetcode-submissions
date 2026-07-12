class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        back(0,nums,new ArrayList<>());
        return ans;
    }
    private void back(int idx,int[] nums, List<Integer> sub){
        ans.add(new ArrayList<>(sub));
        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            sub.add(nums[i]);
            back(i+1,nums,sub);
            sub.remove(sub.size()-1);
        }
    }
    }

