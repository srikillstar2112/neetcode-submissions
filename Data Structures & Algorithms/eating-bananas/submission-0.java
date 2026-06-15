class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=0;
        for(int i:piles){
            r=Math.max(i,r);
        }
        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            long hour=0;
            for(int i:piles){
                hour += (i+mid-1)/mid;
            }
            if(hour<=h){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}
