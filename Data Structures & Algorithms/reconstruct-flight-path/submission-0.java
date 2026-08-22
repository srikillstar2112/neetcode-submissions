class Solution {
    private void dfs(List<String> ans, 
    Map<String,PriorityQueue<String>> map,String airport){
        PriorityQueue<String> pq=map.get(airport);
        while(pq!=null && !pq.isEmpty()){
            String next=pq.poll();
            dfs(ans,map,next);
        }
        ans.add(0,airport);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> map=new HashMap<>();
        List<String> ans=new ArrayList<>();
        for(List<String> ticket: tickets){
            String from=ticket.get(0);
            String to=ticket.get(1);
            map.computeIfAbsent(from,x->new PriorityQueue<>())
            .offer(to);
        }
        dfs(ans,map,"JFK");
        return ans;
    }

}
