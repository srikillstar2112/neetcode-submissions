class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freq=new HashMap<>();
        for(char c:tasks){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer> max=new PriorityQueue<>((a,b)-> b-a);
        max.addAll(freq.values());
        int time=0;
        while(!max.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<n+1;i++){
                if(!max.isEmpty()){
                    temp.add(max.poll());
                }
            }
            for(int f:temp){
                if(--f>0){
                    max.add(f);
                }
            }
            time+=max.isEmpty() ? temp.size() : n+1 ;
        }
        return time;
    }
}
