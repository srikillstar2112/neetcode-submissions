class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i:edges){
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        boolean[] vis=new boolean[n];
        if(hascycle(0,-1,graph,vis)){
            return false;
        }
        for(boolean v:vis){
            if(!v) return false;
        }
        return true;
    }
    private boolean hascycle(int src,int par,List<List<Integer>> graph,boolean[] vis){
        vis[src]=true;
        for(int i:graph.get(src)){
            if(!vis[i]){
                if(hascycle(i,src,graph,vis)){
                    return true;
                }
            }else if(i!=par){
                return true;
            }
        }
        return false;
    }
}
