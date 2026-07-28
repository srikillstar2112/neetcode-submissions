class Solution {
    private void dfs(int[] vis,List<List<Integer>> adj,int node){
        vis[node]=1;
        for(int i:adj.get(node)){
            if(vis[i]==0){
                dfs(vis,adj,i);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        int c=0;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i:edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(vis,adj,i);
                c++;
            }
        }
        return c;
    }
}
