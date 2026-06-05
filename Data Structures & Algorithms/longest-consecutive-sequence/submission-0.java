class Solution {
    public int longestConsecutive(int[] nums) {
        java.util.Arrays.sort(nums);
        HashSet<Integer> table=new HashSet<>();
        for(int i:nums){
            table.add(i);
        }
        int max=0;
        for(int num:table){
            if(!table.contains(num-1)){
                int streak=1;
                int curr=num;
                while(table.contains(curr+1)){
                    curr++;
                    streak++;
                }
                max=Math.max(streak,max);
            }
        }
        return max;
    }
}

