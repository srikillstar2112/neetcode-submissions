class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int []>> map=new HashMap<>();
        for(int[] edge: times){
            map.computeIfAbsent(edge[0],x-> new ArrayList<>()).add(new int[]{edge[2],edge[1]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,k});
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int currdist=curr[0];
            int currnode=curr[1];
            if(currdist>dist[currnode]){
                continue;
            }
            if(map.containsKey(currnode)){
                for(int[] adj : map.get(currnode)){
                    int nextdist=adj[0];
                    int nextnode=adj[1];
                    int sum=nextdist+currdist;
                    if(sum<dist[nextnode]){
                        dist[nextnode]=sum;
                        pq.offer(new int[]{sum,nextnode});
                    }
                }
            }
        }
        int max=0;
        for(int i=1;i<=dist.length-1;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(dist[i],max);
        }
        return max;
    }
}
