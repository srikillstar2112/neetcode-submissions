class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent=new int[edges.length+1];
        for(int i=1;i<=edges.length;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int node1=edge[0];
            int node2=edge[1];
            int r1=find(parent,node1);
            int r2=find(parent,node2);
            if(r1==r2){
                return edge;
            }
            parent[r2]=r1;
        }
        return new int[0];
    }
    private int find(int[] parent,int node){
        while(node!=parent[node]){
            parent[node]=parent[parent[node]];
            node=parent[node];
        }
        return node;
    }
}
