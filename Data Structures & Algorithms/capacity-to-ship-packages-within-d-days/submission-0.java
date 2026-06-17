class Solution {
    private int fdays(int[] weights,int cap){
        int days=1;
        int load=0;
        for(int w:weights){
            if( load+w > cap){
                days++;
                load=w;
            }else{
                load+=w;
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l=0;
        int h=0;
        for(int w:weights){
            l=Math.max(l,w);
            h+=w;
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            int d=fdays(weights,mid);
            if(d<=days){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}