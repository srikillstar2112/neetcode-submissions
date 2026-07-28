class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i:prerequisites){
            adj.get(i[1]).add(i[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] topo=new int[n];
        int idx=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topo[idx++]=node;
            for(int i: adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        if(idx==n) return topo;
        int[] arr={};
        return arr;
    }
}
