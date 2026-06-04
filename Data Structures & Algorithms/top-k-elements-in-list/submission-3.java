class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer>[] buck=new ArrayList[nums.length+1];
        for(int i:map.keySet()){
            int c=map.get(i);
            if(buck[c]==null){
                buck[c]= new ArrayList<>();
            }
            buck[c].add(i);
        }
        int [] res=new int[k];
        int idx=0;
        for(int i=buck.length-1;i>=0 && idx<k;i--){
            if(buck[i]!=null){
                for(int j:buck[i]){
                    res[idx++]=j;

                    if(idx==k){
                        break;
                    }
                }
            }
        }
        return res;
    }
}
