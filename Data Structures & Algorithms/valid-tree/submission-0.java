class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] par:edges){
            adj.get(par[1]).add(par[0]);
        }

        for(int i=0;i<n;i++){
            if(adj.get(i).size()>1){
                return false;
            }
        }
        return true;
    }
}
