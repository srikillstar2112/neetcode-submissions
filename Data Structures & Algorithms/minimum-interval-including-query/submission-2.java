class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n=queries.length;
        int[][] sorted=new int[n][2];
        for(int i=0;i<n;i++){
            sorted[i][0]=queries[i];
            sorted[i][1]=i;
        }
        Arrays.sort(sorted,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] ans=new int[n];
        int i=0;
        for(int[] q:sorted){
            int query=q[0];
            int idx=q[1];
            //Start<=Query add intervals
            while(i<intervals.length && intervals[i][0]<=query){
                int left=intervals[i][0];
                int right=intervals[i][1];
                pq.offer(new int[]{right-left+1,right});
                i++;
            }
            //Remove expired intervals
            while(!pq.isEmpty() && pq.peek()[1]<query){
                pq.poll();
            }
            ans[idx]=pq.isEmpty() ? -1: pq.peek()[0];
        }
        return ans;
    }
}
