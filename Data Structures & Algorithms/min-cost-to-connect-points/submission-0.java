class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int[] dist=new int[n];
        boolean[] visited=new boolean[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int ans=0;
        dist[0]=0;
        for(int i=0;i<n;i++){
            int curr=-1;
            for(int j=0;j<n;j++){
                if(!visited[j] && (curr==-1 || dist[j]<dist[curr])){
                    curr=j;
                }
            }
            visited[curr]=true;
            ans+=dist[curr];
            for(int j=0;j<n;j++){
                if(!visited[j]){
                    int cost=Math.abs(points[curr][0]-points[j][0])
                            +Math.abs(points[curr][1]-points[j][1]);
                    dist[j]=Math.min(dist[j],cost);
                }
            }
        }
        return ans;
    }
}
