class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] i:prerequisites){
            adj.get(i[0]).add(i[1]);
        }
        int[] state=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(state[i]==0){
                if(dfs(i,adj,state)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int node,List<List<Integer>> adj,int[] state){
        state[node]=1;
        for(int i: adj.get(node)){
            if(state[i]==1){
                return true;
            }
            if(state[i]==0){
                if(dfs(i,adj,state)){
                    return true;
                }
            }
        }
        state[node]=2;
        return false;
    }
}
